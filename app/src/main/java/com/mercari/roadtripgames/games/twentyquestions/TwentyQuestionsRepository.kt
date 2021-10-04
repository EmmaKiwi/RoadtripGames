package com.mercari.roadtripgames.games.twentyquestions

import com.mercari.roadtripgames.database.AppDatabase
import javax.inject.Inject

class TwentyQuestionsRepository @Inject constructor(
    private val database: AppDatabase
): TwentyQuestionsContract.Repository {

    override fun getQuestionCategories() = database.questionCategoryDao().getAll()
}