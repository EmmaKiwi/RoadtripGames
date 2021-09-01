package com.mercari.roadtripgames.login.di

import com.mercari.roadtripgames.login.LoginContract
import com.mercari.roadtripgames.login.LoginNavigator
import com.mercari.roadtripgames.login.LoginRepository
import dagger.Binds
import dagger.Module

@Module
interface LoginModule {

    @Binds
    fun bindsNavigator(navigator: LoginNavigator): LoginContract.Navigator

    @Binds
    fun bindsRepository(repository: LoginRepository): LoginContract.Repository
}