package com.mercari.roadtripgames.games.numberplate.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NumberPlateGame(
    @PrimaryKey
    val gameId: String,
    val userId: Long
)