package com.mercari.roadtripgames.auth

import dagger.Binds
import dagger.Module

@Module
interface AuthModule {

    @Binds
    fun bindsAuth(auth: AuthImpl): Auth
}