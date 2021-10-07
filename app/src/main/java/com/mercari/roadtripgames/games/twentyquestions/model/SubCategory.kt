package com.mercari.roadtripgames.games.twentyquestions.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SubCategory(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val name: String,
    val categoryId: Long
)