package com.mercari.roadtripgames.games.numberplate.game

import com.mercari.roadtripgames.database.AppDatabase
import com.mercari.roadtripgames.games.numberplate.NumberPlateContract
import com.mercari.roadtripgames.games.numberplate.model.NumberPlate
import javax.inject.Inject

class NumberPlateGameRepository @Inject constructor(
    private val database: AppDatabase
): NumberPlateContract.GameRepository {

    override fun getNumberPlates(gameId: String) = database.numberPlateDao().getByGameId(gameId)

    override suspend fun insertNumberPlates(numberPlates: List<NumberPlate>) =
        database.numberPlateDao().insertAll(numberPlates)

    override suspend fun updatePlate(plate: NumberPlate) = database.numberPlateDao().update(plate)

    override suspend fun resetAllPlates(plates: List<NumberPlate>) = database.numberPlateDao().updateAll(plates)
}
