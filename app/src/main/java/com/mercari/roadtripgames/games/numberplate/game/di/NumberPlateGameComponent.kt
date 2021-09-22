package com.mercari.roadtripgames.games.numberplate.game.di

import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.games.numberplate.di.NumberPlateModule
import com.mercari.roadtripgames.games.numberplate.game.NumberPlateGameFragment
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Qualifier

@Subcomponent(modules = [NumberPlateGameModule::class, NumberPlateModule::class])
interface NumberPlateGameComponent {
    fun inject(fragment: NumberPlateGameFragment)

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class GameId

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        @BindsInstance
        fun gameId(@GameId gameId: String): Builder

        fun build(): NumberPlateGameComponent
    }
}