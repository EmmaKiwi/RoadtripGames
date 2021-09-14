package com.mercari.roadtripgames.games.numberplate.di

import com.mercari.roadtripgames.games.numberplate.NumberPlateContract
import com.mercari.roadtripgames.games.numberplate.NumberPlateNavigator
import dagger.Binds
import dagger.Module

@Module
interface NumberPlateModule {

    @Binds
    fun bindsNavigator(navigator: NumberPlateNavigator): NumberPlateContract.Navigator
}
