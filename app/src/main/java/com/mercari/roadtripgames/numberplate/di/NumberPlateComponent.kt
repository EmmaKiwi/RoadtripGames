package com.mercari.roadtripgames.numberplate.di

import android.content.Context
import com.mercari.roadtripgames.numberplate.NumberPlateActivity
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
