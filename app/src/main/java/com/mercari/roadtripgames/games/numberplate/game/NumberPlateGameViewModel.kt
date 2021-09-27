package com.mercari.roadtripgames.games.numberplate.game

import androidx.lifecycle.*
import com.mercari.roadtripgames.games.numberplate.model.NumberPlate
import com.mercari.roadtripgames.games.numberplate.NumberPlateContract
import com.mercari.roadtripgames.games.numberplate.NumberPlateType
import com.mercari.roadtripgames.games.numberplate.game.di.NumberPlateGameComponent
import kotlinx.coroutines.launch
import javax.inject.Inject

class NumberPlateGameViewModel @Inject constructor(
    private val repository: NumberPlateContract.GameRepository,
    @NumberPlateGameComponent.GameId private val gameId: String
) : ViewModel() {

    private var filterString = MutableLiveData<String?>()
    private val allNumberPlates = MediatorLiveData<List<NumberPlate>>().apply {
        addSource(repository.getNumberPlates(gameId)) { plates ->
            value = plates.sortedBy { it.isFound }
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
}
