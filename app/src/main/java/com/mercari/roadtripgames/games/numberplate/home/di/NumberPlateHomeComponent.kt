package com.mercari.roadtripgames.games.numberplate.home.di

import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.games.numberplate.di.NumberPlateModule
import com.mercari.roadtripgames.games.numberplate.home.NumberPlateHomeFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [NumberPlateModule::class, NumberPlateHomeModule::class])
interface NumberPlateHomeComponent {
    fun inject(fragment: NumberPlateHomeFragment)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        fun build(): NumberPlateHomeComponent
    }
}