package com.mercari.roadtripgames.games.numberplate

import androidx.lifecycle.LiveData

interface NumberPlateContract {
    interface Navigator {
        fun showHomeFragment()
        fun showGameFragment()
    }
    interface Repository {
        fun getNumberPlates(): LiveData<List<NumberPlate>>
        suspend fun insertNumberPlates(numberPlates: List<NumberPlate>)
        suspend fun updatePlate(plate: NumberPlate)
        suspend fun resetAllPlates(plates: List<NumberPlate>)
    }
}