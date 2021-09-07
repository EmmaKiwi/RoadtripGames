package com.mercari.roadtripgames.games.numberplate.di

import com.mercari.roadtripgames.games.numberplate.NumberPlateActivity
import dagger.Subcomponent

@Subcomponent(modules = [NumberPlateModule::class])
interface NumberPlateComponent {
    fun inject(activity: NumberPlateActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): NumberPlateComponent
    }
}
