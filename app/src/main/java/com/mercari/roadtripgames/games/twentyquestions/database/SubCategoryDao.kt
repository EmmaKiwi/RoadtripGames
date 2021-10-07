package com.mercari.roadtripgames.games.twentyquestions.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mercari.roadtripgames.games.twentyquestions.model.SubCategory

@Dao
interface SubCategoryDao {

    @Query("SELECT * from subcategory where categoryId = :categoryId")
    fun getByCategoryId(categoryId: Long): List<SubCategory>

    @Insert
    suspend fun insertAll(subCategories: List<SubCategory>)
}