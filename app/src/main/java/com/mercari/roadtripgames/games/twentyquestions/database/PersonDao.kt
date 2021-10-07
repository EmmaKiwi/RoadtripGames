package com.mercari.roadtripgames.games.twentyquestions.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mercari.roadtripgames.games.twentyquestions.model.Person

@Dao
interface PersonDao {

    @Query("SELECT * from person")
    fun getAll(): LiveData<List<Person>>

    @Insert
    suspend fun insertAll(people: List<Person>)
}