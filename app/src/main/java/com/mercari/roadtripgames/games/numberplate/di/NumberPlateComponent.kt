package com.mercari.roadtripgames.games.numberplate.di

import android.content.Context
import com.mercari.roadtripgames.games.numberplate.NumberPlateActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [NumberPlateModule::class])
interface NumberPlateComponent {
    fun inject(activity: NumberPlateActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): NumberPlateComponent

        @BindsInstance
        fun context(context: Context): Builder
    }
}
