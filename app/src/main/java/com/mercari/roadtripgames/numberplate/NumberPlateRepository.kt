package com.mercari.roadtripgames.numberplate

import com.mercari.roadtripgames.database.AppDatabase
import javax.inject.Inject

class NumberPlateRepository @Inject constructor(private val database: AppDatabase) {

    fun getNumberPlates() = database.numberPlateDao().getAll()

    suspend fun insertNumberPlates(numberPlates: List<NumberPlate>) =
        database.numberPlateDao().insertAll(numberPlates)

    suspend fun updatePlate(plate: NumberPlate) = database.numberPlateDao().update(plate)
}
