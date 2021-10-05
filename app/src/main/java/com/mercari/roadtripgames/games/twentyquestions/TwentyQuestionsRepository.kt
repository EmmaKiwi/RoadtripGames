package com.mercari.roadtripgames.games.twentyquestions

import com.mercari.roadtripgames.database.AppDatabase
import com.mercari.roadtripgames.games.twentyquestions.model.QuestionCategory
import javax.inject.Inject

class TwentyQuestionsRepository @Inject constructor(
    private val database: AppDatabase
): TwentyQuestionsContract.Repository {

    override fun getQuestionCategories() = database.questionCategoryDao().getAll()

    override suspend fun generateDefaultCategories() {
        val categories = createDefaultCategories()
        database.questionCategoryDao().insertAll(categories)
    }

    private fun createDefaultCategories() = listOf(
        QuestionCategory(
            title = "Animal",
            subtitle = "Generate a random animal"
        ),
        QuestionCategory(
            title = "Plant",
            subtitle = "Generate a random plant"
        ),
        QuestionCategory(
            title = "Mineral",
            subtitle = "Something that isn't an animal or a plant"
        ),
        QuestionCategory(
            title = "Person",
            subtitle = "A famous person, alive or dead"
        ),
        QuestionCategory(
            title = "Event",
            subtitle = "A famous event from history"
        )
    )
}