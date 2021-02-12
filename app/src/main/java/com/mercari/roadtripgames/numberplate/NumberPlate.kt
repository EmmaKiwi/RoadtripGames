package com.mercari.roadtripgames.numberplate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NumberPlate(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo val type: NumberPlateType,
    @ColumnInfo val isFound: Boolean = false,
    @ColumnInfo val dateFound: String? = null
)
