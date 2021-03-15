package com.mercari.roadtripgames.numberplate

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NumberPlateDao {

    @Query("SELECT * from numberplate")
    fun getAll(): LiveData<List<NumberPlate>>

    @Insert()
    suspend fun insertAll(numberPlates: List<NumberPlate>)

    @Update
    suspend fun update(numberPlate: NumberPlate)

    @Update
    suspend fun updateAll(numberPlate: List<NumberPlate>)

    @Delete
    suspend fun delete(numberPlate: NumberPlate)
}
