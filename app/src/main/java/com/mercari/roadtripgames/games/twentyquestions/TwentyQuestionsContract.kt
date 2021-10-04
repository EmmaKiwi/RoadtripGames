package com.mercari.roadtripgames.games.twentyquestions

import com.mercari.roadtripgames.games.twentyquestions.model.QuestionCategory

interface TwentyQuestionsContract {
    interface Repository {
        fun getQuestionCategories(): List<QuestionCategory>
    }
}