package com.mercari.roadtripgames.games.twentyquestions

import androidx.lifecycle.LiveData
import com.mercari.roadtripgames.games.twentyquestions.model.QuestionCategory

interface TwentyQuestionsContract {
    interface Repository {
        fun getQuestionCategories(): LiveData<List<QuestionCategory>>
        suspend fun generateDefaultCategories()
    }
}