package com.mercari.roadtripgames

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.auth.AuthModule
import com.mercari.roadtripgames.database.DatabaseModule
import com.mercari.roadtripgames.login.di.LoginComponent
import com.mercari.roadtripgames.games.numberplate.di.NumberPlateComponent
import com.mercari.roadtripgames.login.signup.di.SignupComponent
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DatabaseModule::class, AuthModule::class])
interface AppComponent {

    fun inject(activity: AppCompatActivity)

    fun newLoginComponent(): LoginComponent.Builder
    fun newSignupComponent(): SignupComponent.Builder
    fun newNumberPlateComponent(): NumberPlateComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}