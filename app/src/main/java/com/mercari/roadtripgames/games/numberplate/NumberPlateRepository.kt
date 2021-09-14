package com.mercari.roadtripgames.games.numberplate

import com.mercari.roadtripgames.database.AppDatabase
import javax.inject.Inject

class NumberPlateRepository @Inject constructor(
    private val database: AppDatabase
): NumberPlateContract.Repository {

    override fun getNumberPlates() = database.numberPlateDao().getAll()

    override suspend fun insertNumberPlates(numberPlates: List<NumberPlate>) =
        database.numberPlateDao().insertAll(numberPlates)

    override suspend fun updatePlate(plate: NumberPlate) = database.numberPlateDao().update(plate)

    override suspend fun resetAllPlates(plates: List<NumberPlate>) = database.numberPlateDao().updateAll(plates)
}
