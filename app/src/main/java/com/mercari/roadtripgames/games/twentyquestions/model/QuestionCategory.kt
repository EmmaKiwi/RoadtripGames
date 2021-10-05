package com.mercari.roadtripgames.games.twentyquestions.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuestionCategory(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val title: String,
    val subtitle: String
)