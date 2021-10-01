package com.mercari.roadtripgames.games.numberplate.home

import androidx.lifecycle.LiveData
import com.mercari.roadtripgames.database.AppDatabase
import com.mercari.roadtripgames.games.numberplate.NumberPlateContract
import com.mercari.roadtripgames.games.numberplate.model.NumberPlate
import com.mercari.roadtripgames.games.numberplate.model.NumberPlateGame
import javax.inject.Inject

class NumberPlateHomeRepository @Inject constructor(
    private val database: AppDatabase
): NumberPlateContract.HomeRepository {

    override fun getAllGames(userId: Long): LiveData<List<NumberPlateGame>> =
        database.numberPlateGameDao().getByUserId(userId)

    override suspend fun addNewGame(game: NumberPlateGame) =
        database.numberPlateGameDao().insert(game)

    override suspend fun addGamePlates(numberPlates: List<NumberPlate>) =
        database.numberPlateDao().insertAll(numberPlates)

    override suspend fun deleteGame(game: NumberPlateGame) =
        database.numberPlateGameDao().deleteGame(game)
}