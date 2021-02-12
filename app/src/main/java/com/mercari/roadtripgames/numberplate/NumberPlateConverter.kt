package com.mercari.roadtripgames.numberplate

import androidx.room.TypeConverter

class NumberPlateConverter {

    @TypeConverter
    fun toNumberPlate(value: Int) = enumValues<NumberPlateType>()[value]

    @TypeConverter
    fun fromNumberPlate(value: NumberPlateType) = value.ordinal
}
