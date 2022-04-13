package com.mercari.roadtripgames.games.twentyquestions.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val name: String,
    val subCategoryId: Long,
    val description: String,
    val country: String,
    val dateOfBirth: String
)