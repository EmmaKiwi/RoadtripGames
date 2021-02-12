package com.mercari.roadtripgames.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mercari.roadtripgames.numberplate.NumberPlate
import com.mercari.roadtripgames.numberplate.NumberPlateConverter
import com.mercari.roadtripgames.numberplate.NumberPlateDao

@Database(entities = [NumberPlate::class], version = 1)
@TypeConverters(NumberPlateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun numberPlateDao(): NumberPlateDao
}
