package com.mercari.roadtripgames.games.numberplate.game.di

import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.games.numberplate.di.NumberPlateModule
import com.mercari.roadtripgames.games.numberplate.game.NumberPlateGameFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [NumberPlateGameModule::class, NumberPlateModule::class])
interface NumberPlateGameComponent {
    fun inject(fragment: NumberPlateGameFragment)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        fun build(): NumberPlateGameComponent
    }
}