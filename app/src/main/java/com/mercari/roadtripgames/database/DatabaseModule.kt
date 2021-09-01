package com.mercari.roadtripgames.database

import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun providesDatabase(activity: AppCompatActivity): AppDatabase {
        return Room.databaseBuilder(
            activity,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}