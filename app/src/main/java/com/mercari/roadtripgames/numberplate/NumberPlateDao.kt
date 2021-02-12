package com.mercari.roadtripgames.numberplate

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NumberPlateDao {

    @Query("SELECT * from numberplate")
    suspend fun getAll(): List<NumberPlate>

    @Insert
    suspend fun insertAll(numberPlate: List<NumberPlate>)

    @Delete
    suspend fun delete(numberPlate: NumberPlate)
}
