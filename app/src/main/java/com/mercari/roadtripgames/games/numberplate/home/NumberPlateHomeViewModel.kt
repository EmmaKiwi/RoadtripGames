package com.mercari.roadtripgames.games.numberplate.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercari.roadtripgames.auth.Auth
import com.mercari.roadtripgames.games.numberplate.NumberPlateContract
import com.mercari.roadtripgames.games.numberplate.model.NumberPlateGame
import kotlinx.coroutines.launch
import javax.inject.Inject

class NumberPlateHomeViewModel @Inject constructor(
    private val auth: Auth,
    private val repository: NumberPlateContract.HomeRepository
): ViewModel() {
    private val allGames = auth.getUser()?.let {
        repository.getAllGames(it.id)
    } ?: repository.getAllGames(GUEST_ID)

    fun addNewGame() {
        val userId = auth.getUser()?.id ?: GUEST_ID
        val newGame = NumberPlateGame(getNewGameId(), userId)
        viewModelScope.launch {
            repository.addNewGame(newGame)
        }
    }

    private fun getNewGameId() = System.currentTimeMillis().toString()

    companion object {
        private const val GUEST_ID = -1L
    }
}