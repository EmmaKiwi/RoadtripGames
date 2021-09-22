package com.mercari.roadtripgames.games.numberplate.home.di

import com.mercari.roadtripgames.games.numberplate.NumberPlateContract
import com.mercari.roadtripgames.games.numberplate.home.NumberPlateHomeRepository
import dagger.Binds
import dagger.Module

@Module
interface NumberPlateHomeModule {
    @Binds
    fun bindsRepository(
        repository: NumberPlateHomeRepository
    ): NumberPlateContract.HomeRepository
}