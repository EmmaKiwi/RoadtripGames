package com.mercari.roadtripgames.home.di

import com.mercari.roadtripgames.home.HomeContract
import com.mercari.roadtripgames.home.HomeNavigator
import dagger.Binds
import dagger.Module

@Module
abstract class HomeModule {

    @Binds
    abstract fun providesNavigator(navigator: HomeNavigator): HomeContract.Navigator
}
