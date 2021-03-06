package com.mercari.roadtripgames.login.signup.di

import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.login.signup.SignupActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [SignupModule::class])
interface SignupComponent {

    fun inject(activity: SignupActivity)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        fun build(): SignupComponent
    }
}