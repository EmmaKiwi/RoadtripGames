package com.mercari.roadtripgames.login.di

import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.login.LoginActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [LoginModule::class])
interface LoginComponent {
    fun inject(activity: LoginActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        fun build(): LoginComponent
    }
}