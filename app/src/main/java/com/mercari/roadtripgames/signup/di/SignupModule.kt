package com.mercari.roadtripgames.signup.di

import com.mercari.roadtripgames.signup.SignupContract
import com.mercari.roadtripgames.signup.SignupRepository
import dagger.Binds
import dagger.Module

@Module
interface SignupModule {

    @Binds
    fun bindsRepository(repository: SignupRepository): SignupContract.Repository
}