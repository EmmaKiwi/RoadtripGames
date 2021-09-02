package com.mercari.roadtripgames.database

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun providesDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}