package com.mercari.roadtripgames.games.numberplate.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mercari.roadtripgames.games.numberplate.NumberPlateType

@Entity
data class NumberPlate(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo val type: NumberPlateType,
    @ColumnInfo var isFound: Boolean = false,
    @ColumnInfo var dateFound: String? = null,
    @ColumnInfo var gameId: String
)
