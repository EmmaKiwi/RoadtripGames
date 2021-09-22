package com.mercari.roadtripgames.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mercari.roadtripgames.games.numberplate.model.NumberPlate
import com.mercari.roadtripgames.games.numberplate.NumberPlateConverter
import com.mercari.roadtripgames.games.numberplate.database.NumberPlateDao
import com.mercari.roadtripgames.auth.user.User
import com.mercari.roadtripgames.auth.user.UserDao
import com.mercari.roadtripgames.games.numberplate.database.NumberPlateGameDao
import com.mercari.roadtripgames.games.numberplate.model.NumberPlateGame

@Database(entities = [NumberPlate::class, NumberPlateGame::class, User::class], version = 1)
@TypeConverters(NumberPlateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun numberPlateDao(): NumberPlateDao
    abstract fun numberPlateGameDao(): NumberPlateGameDao
    abstract fun userDao(): UserDao
}
