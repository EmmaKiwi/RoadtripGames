package com.mercari.roadtripgames.games.numberplate.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mercari.roadtripgames.games.numberplate.model.NumberPlateGame

@Dao
interface NumberPlateGameDao {

    @Query("SELECT * from numberplategame")
    fun getAll(): LiveData<List<NumberPlateGame>>

    @Query("SELECT * from numberplategame where userId = :userId")
    fun getByUserId(userId: Long): LiveData<List<NumberPlateGame>>

    @Query("SELECT * from numberplategame where gameId = :gameId")
    fun getByGameId(gameId: String): LiveData<NumberPlateGame>

    @Insert
    suspend fun insert(game: NumberPlateGame)
}