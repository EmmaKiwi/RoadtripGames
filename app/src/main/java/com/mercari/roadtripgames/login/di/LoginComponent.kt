package com.mercari.roadtripgames.login.di

import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.database.DatabaseModule
import com.mercari.roadtripgames.login.LoginActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@Subcomponent(modules = [LoginModule::class])
interface LoginComponent {
    fun inject(activity: LoginActivity)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        fun build(): LoginComponent
    }
}