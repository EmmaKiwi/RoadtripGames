package com.mercari.roadtripgames.games.twentyquestions.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuestionCategory(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val title: String,
    val subtitle: String
)