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
import com.mercari.roadtripgames.games.twentyquestions.database.MovieDao
import com.mercari.roadtripgames.games.twentyquestions.database.PersonDao
import com.mercari.roadtripgames.games.twentyquestions.database.QuestionCategoryDao
import com.mercari.roadtripgames.games.twentyquestions.model.Movie
import com.mercari.roadtripgames.games.twentyquestions.model.Person
import com.mercari.roadtripgames.games.twentyquestions.model.QuestionCategory

@Database(
    entities = [
        NumberPlate::class,
        NumberPlateGame::class,
        User::class,
        QuestionCategory::class,
        Person::class,
        Movie::class
   ], version = 1
)
@TypeConverters(NumberPlateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun numberPlateDao(): NumberPlateDao
    abstract fun numberPlateGameDao(): NumberPlateGameDao
    abstract fun userDao(): UserDao
    abstract fun questionCategoryDao(): QuestionCategoryDao
    abstract fun personDao(): PersonDao
    abstract fun movieDao(): MovieDao
}
