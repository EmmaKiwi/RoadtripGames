package com.mercari.roadtripgames.games.numberplate.di

import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.games.numberplate.NumberPlateActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [NumberPlateModule::class])
interface NumberPlateComponent {
    fun inject(activity: NumberPlateActivity)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        fun build(): NumberPlateComponent
    }
}
