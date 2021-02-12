package com.mercari.roadtripgames.numberplate.di

import android.content.Context
import androidx.room.Room
import com.mercari.roadtripgames.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class NumberPlateModule(private val context: Context) {

    @Provides
    fun providesDatabase(): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}
