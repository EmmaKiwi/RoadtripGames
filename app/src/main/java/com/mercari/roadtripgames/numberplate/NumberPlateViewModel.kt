package com.mercari.roadtripgames.numberplate

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class NumberPlateViewModel @Inject constructor(
    private val repository: NumberPlateRepository
) : ViewModel() {

    private var filterString = MutableLiveData<String?>()
    private val allNumberPlates = MediatorLiveData<List<NumberPlate>>().apply {
        addSource(repository.getNumberPlates()) { plates ->
            value = if (plates.isEmpty()) {
                val generatedPlates = generatePlates()
                insertNewPlates(generatedPlates)
                generatedPlates.sortedBy { it.isFound }
            } else {
                plates.sortedBy { it.isFound }
            }
        }
    }
    val numberPlates = Transformations.switchMap(filterString) { filter ->
        allNumberPlates.map { plates ->
            filter?.let { filter ->
                plates.filter {
                    it.type.stateName.toLowerCase().contains(filter.toLowerCase())
                }
            } ?: plates
        }
    }
    val isAllPlatesFound = MutableLiveData<Boolean>()

    init {
        filterString.postValue(null)
    }

    fun resetPlates() {
        numberPlates.value?.map {
            it.isFound = false
            it
        }?.let {
            viewModelScope.launch {
                repository.resetAllPlates(it)
            }
            allNumberPlates.postValue(it)
        }
    }

    fun filterPlates(text: String) {
        filterString.postValue(text)
    }

    fun clearSearch() {
        filterString.postValue(null)
    }

    fun insertNewPlates(plates: List<NumberPlate>) {
        viewModelScope.launch {
            repository.insertNumberPlates(plates)
        }
    }

    fun onPlateUpdated(plate: NumberPlate) {
        viewModelScope.launch {
            repository.updatePlate(plate)
            val allFound = numberPlates.value?.all { it.isFound }
            isAllPlatesFound.postValue(allFound)
        }
    }

    private fun generatePlates(): List<NumberPlate> {
        val plates = mutableListOf<NumberPlate>()
        NumberPlateType.values().forEach {
            plates.add(
                NumberPlate(
                    type = it
                )
            )
        }
        return plates
    }
}
