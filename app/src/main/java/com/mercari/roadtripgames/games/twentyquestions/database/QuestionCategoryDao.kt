package com.mercari.roadtripgames.games.twentyquestions.database

import androidx.room.Dao
import androidx.room.Query
import com.mercari.roadtripgames.games.twentyquestions.model.QuestionCategory

@Dao
interface QuestionCategoryDao {

    @Query("SELECT * from questioncategory")
    fun getAll(): List<QuestionCategory>
}