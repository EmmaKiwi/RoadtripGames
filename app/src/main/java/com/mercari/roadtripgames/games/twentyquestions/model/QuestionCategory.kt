package com.mercari.roadtripgames.games.twentyquestions.model

import androidx.room.Entity

@Entity
data class QuestionCategory(
    val title: String,
    val subtitle: String
)