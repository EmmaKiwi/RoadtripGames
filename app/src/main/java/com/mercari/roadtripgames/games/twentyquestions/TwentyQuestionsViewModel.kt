package com.mercari.roadtripgames.games.twentyquestions

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class TwentyQuestionsViewModel @Inject constructor(
    private val repository: TwentyQuestionsContract.Repository
) : ViewModel() {
}