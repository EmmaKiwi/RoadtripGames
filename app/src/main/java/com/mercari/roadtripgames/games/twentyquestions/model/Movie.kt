package com.mercari.roadtripgames.games.twentyquestions.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val categoryId: Long,
    val name: String,
    val genre: String,
    val description: String,
    val releaseDate: Long
)