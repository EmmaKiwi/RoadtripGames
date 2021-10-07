package com.mercari.roadtripgames.games.twentyquestions.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mercari.roadtripgames.games.twentyquestions.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * from movie")
    fun getAll(): LiveData<List<Movie>>

    @Insert
    suspend fun insertAll(movies: List<Movie>)
}