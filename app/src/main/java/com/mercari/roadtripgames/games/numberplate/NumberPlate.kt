package com.mercari.roadtripgames.games.numberplate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NumberPlate(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo val type: NumberPlateType,
    @ColumnInfo var isFound: Boolean = false,
    @ColumnInfo var dateFound: String? = null
)
