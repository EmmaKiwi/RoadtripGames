package com.mercari.roadtripgames.games.twentyquestions

import com.mercari.roadtripgames.database.AppDatabase
import com.mercari.roadtripgames.games.twentyquestions.data.MovieData
import com.mercari.roadtripgames.games.twentyquestions.data.PeopleData
import com.mercari.roadtripgames.games.twentyquestions.model.QuestionCategory
import com.mercari.roadtripgames.games.twentyquestions.model.QuestionCategoryData
import javax.inject.Inject

class TwentyQuestionsRepository @Inject constructor(
    private val database: AppDatabase
) : TwentyQuestionsContract.Repository {

    override fun getQuestionCategories() = database.questionCategoryDao().getAll()

    override suspend fun generateDefaultCategories() {
        val categories = createDefaultCategories()
        val peopleCategories = PeopleData.PeopleCategories.values()
        database.questionCategoryDao().insertAll(categories.map { it.toQuestionCategory() })
        database.questionCategoryDao().insertAll(peopleCategories.map { it.toQuestionCategory() })
        categories.forEach {
            when (it) {
                QuestionCategoryData.PERSON -> generatePeople(it.id)
                QuestionCategoryData.MOVIE -> generateMovies(it.id)
            }
        }
    }

    private suspend fun generatePeople(categoryId: Long) {
        val people = PeopleData.getPeople(categoryId)
        database.personDao().insertAll(people)
    }

    private suspend fun generateMovies(categoryId: Long) {
        val movies = MovieData.getMovies(categoryId)
        database.movieDao().insertAll(movies)
    }

    private fun createDefaultCategories() =
        QuestionCategoryData.values()
}