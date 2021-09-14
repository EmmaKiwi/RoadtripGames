package com.mercari.roadtripgames.games.numberplate.game.di

import com.mercari.roadtripgames.games.numberplate.NumberPlateContract
import com.mercari.roadtripgames.games.numberplate.NumberPlateRepository
import dagger.Binds
import dagger.Module

@Module
interface NumberPlateGameModule {

    @Binds
    fun bindsRepository(repository: NumberPlateRepository): NumberPlateContract.Repository
}