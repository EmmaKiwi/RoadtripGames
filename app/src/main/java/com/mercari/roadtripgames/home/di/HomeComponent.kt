package com.mercari.roadtripgames.home.di

import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.home.HomeActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [HomeModule::class])
interface HomeComponent {

    fun inject(activity: HomeActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): HomeComponent

        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder
    }
}
