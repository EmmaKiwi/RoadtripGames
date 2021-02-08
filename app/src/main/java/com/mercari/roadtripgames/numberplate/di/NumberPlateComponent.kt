package com.mercari.roadtripgames.numberplate.di

import com.mercari.roadtripgames.numberplate.NumberPlateActivity
import dagger.Component

@Component(modules = [NumberPlateModule::class])
interface NumberPlateComponent {
    fun inject(activity: NumberPlateActivity)
}
