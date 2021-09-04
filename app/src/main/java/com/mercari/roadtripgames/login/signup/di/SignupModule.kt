package com.mercari.roadtripgames.login.signup.di

import com.mercari.roadtripgames.login.signup.SignupContract
import com.mercari.roadtripgames.login.signup.SignupNavigator
import com.mercari.roadtripgames.login.signup.SignupRepository
import dagger.Binds
import dagger.Module

@Module
interface SignupModule {

    @Binds
    fun bindsRepository(repository: SignupRepository): SignupContract.Repository

    @Binds
    fun bindsNavigator(navigator: SignupNavigator): SignupContract.Navigator
}