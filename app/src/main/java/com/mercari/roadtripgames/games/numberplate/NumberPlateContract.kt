package com.mercari.roadtripgames.games.numberplate

import androidx.lifecycle.LiveData
import com.mercari.roadtripgames.games.numberplate.model.NumberPlate
import com.mercari.roadtripgames.games.numberplate.model.NumberPlateGame

interface NumberPlateContract {
    interface Navigator {
        fun showHomeFragment()
        fun showGameFragment()
        fun back()
    }

    interface GameRepository {
        fun getNumberPlates(): LiveData<List<NumberPlate>>
        suspend fun insertNumberPlates(numberPlates: List<NumberPlate>)
        suspend fun updatePlate(plate: NumberPlate)
        suspend fun resetAllPlates(plates: List<NumberPlate>)
    }

    interface HomeRepository {
        fun getAllGames(userId: Long): LiveData<List<NumberPlateGame>>
        suspend fun addNewGame(game: NumberPlateGame)
    }
}