package com.mercari.roadtripgames.games.numberplate.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mercari.roadtripgames.games.numberplate.model.NumberPlate

@Dao
interface NumberPlateDao {

    @Query("SELECT * from numberplate where gameId = :gameId")
    fun getByGameId(gameId: String): LiveData<List<NumberPlate>>

    @Insert()
    suspend fun insertAll(numberPlates: List<NumberPlate>)

    @Update
    suspend fun update(numberPlate: NumberPlate)

    @Update
    suspend fun updateAll(numberPlate: List<NumberPlate>)

    @Delete
    suspend fun delete(numberPlate: NumberPlate)
}
