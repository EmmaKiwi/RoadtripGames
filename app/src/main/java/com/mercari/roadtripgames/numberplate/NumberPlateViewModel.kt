package com.mercari.roadtripgames.numberplate

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import javax.inject.Inject

class NumberPlateViewModel @Inject constructor(
    private val repository: NumberPlateRepository
) : ViewModel() {

    val numberPlates: LiveData<List<NumberPlate>> = liveData {
        val plates = repository.getNumberPlates()
        if (plates.isEmpty()) {
            val generatedPlates = generatePlates()
            repository.insertNumberPlates(generatedPlates)
            emit(generatedPlates)
        } else {
            emit(plates)
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
