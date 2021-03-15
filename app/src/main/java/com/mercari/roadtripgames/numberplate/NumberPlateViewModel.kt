package com.mercari.roadtripgames.numberplate

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class NumberPlateViewModel @Inject constructor(
    private val repository: NumberPlateRepository
) : ViewModel() {

    val numberPlates = MediatorLiveData<List<NumberPlate>>().apply {
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
    val isAllPlatesFound = MutableLiveData<Boolean>()

    fun resetPlates() {
        numberPlates.value?.map {
            it.isFound = false
            it
        }?.let {
            viewModelScope.launch {
                repository.resetAllPlates(it)
            }
            numberPlates.postValue(it)
        }
    }

    fun insertNewPlates(plates: List<NumberPlate>) {
        viewModelScope.launch {
            repository.insertNumberPlates(plates)
        }
    }

    fun onPlateFound(plate: NumberPlate) {
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
