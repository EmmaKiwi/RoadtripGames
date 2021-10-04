package com.mercari.roadtripgames.games.twentyquestions.di

import com.mercari.roadtripgames.games.twentyquestions.TwentyQuestionsContract
import com.mercari.roadtripgames.games.twentyquestions.TwentyQuestionsRepository
import dagger.Binds
import dagger.Module

@Module
interface TwentyQuestionsModule {

    @Binds
    fun bindsRepository(repository: TwentyQuestionsRepository): TwentyQuestionsContract.Repository
}