package com.mercari.roadtripgames.games.twentyquestions.di

import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.games.twentyquestions.TwentyQuestionsActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [TwentyQuestionsModule::class])
interface TwentyQuestionsComponent {

    fun inject(activity: TwentyQuestionsActivity)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        fun build(): TwentyQuestionsComponent
    }
}