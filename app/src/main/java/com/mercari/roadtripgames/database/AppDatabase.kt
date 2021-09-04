package com.mercari.roadtripgames.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mercari.roadtripgames.games.numberplate.NumberPlate
import com.mercari.roadtripgames.games.numberplate.NumberPlateConverter
import com.mercari.roadtripgames.games.numberplate.NumberPlateDao
import com.mercari.roadtripgames.auth.user.User
import com.mercari.roadtripgames.auth.user.UserDao

@Database(entities = [NumberPlate::class, User::class], version = 1)
@TypeConverters(NumberPlateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun numberPlateDao(): NumberPlateDao
    abstract fun userDao(): UserDao
}
