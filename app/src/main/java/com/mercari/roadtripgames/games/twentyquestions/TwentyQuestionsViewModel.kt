package com.mercari.roadtripgames.games.twentyquestions

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.mercari.roadtripgames.games.twentyquestions.model.QuestionCategory
import kotlinx.coroutines.launch
import javax.inject.Inject

class TwentyQuestionsViewModel @Inject constructor(
    private val repository: TwentyQuestionsContract.Repository
) : ViewModel() {

    val questionCategories: LiveData<List<QuestionCategory>> =
        repository.getQuestionCategories().map {
            if (it.isEmpty()) {
                viewModelScope.launch {
                    repository.generateDefaultCategories()
                }
            }
            it
        }
}