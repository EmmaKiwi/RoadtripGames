package com.mercari.roadtripgames.games.twentyquestions.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mercari.roadtripgames.games.twentyquestions.model.QuestionCategory

@Dao
interface QuestionCategoryDao {

    @Query("SELECT * from questioncategory")
    fun getAll(): LiveData<List<QuestionCategory>>

    @Insert
    suspend fun insertAll(categories: List<QuestionCategory>)
}