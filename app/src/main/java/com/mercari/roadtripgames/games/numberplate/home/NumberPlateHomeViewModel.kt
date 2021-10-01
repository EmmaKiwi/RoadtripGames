package com.mercari.roadtripgames.games.numberplate.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercari.roadtripgames.auth.Auth
import com.mercari.roadtripgames.games.numberplate.NumberPlateContract
import com.mercari.roadtripgames.games.numberplate.NumberPlateType
import com.mercari.roadtripgames.games.numberplate.model.NumberPlate
import com.mercari.roadtripgames.games.numberplate.model.NumberPlateGame
import kotlinx.coroutines.launch
import javax.inject.Inject

class NumberPlateHomeViewModel @Inject constructor(
    private val auth: Auth,
    private val repository: NumberPlateContract.HomeRepository,
    private val navigator: NumberPlateContract.Navigator
): ViewModel() {
    private val allGames = auth.getUser()?.let {
        repository.getAllGames(it.id)
    } ?: repository.getAllGames(GUEST_ID)

    val games = allGames

    fun addNewGame(name: String) {
        val userId = auth.getUser()?.id ?: GUEST_ID
        val currentTime = System.currentTimeMillis()
        val newGame = NumberPlateGame(getNewGameId(), userId, name, currentTime, currentTime)
        viewModelScope.launch {
            repository.addNewGame(newGame)
            repository.addGamePlates(generatePlates(newGame.gameId))
            navigator.showGameFragment(newGame.gameId)
        }
    }

    fun generateNewGameTitle(): String {
        var suggestedTitle = "${auth.getUser()?.username ?: ""}'s Game"
        var count = 1
        while (allGames.value?.find { it.name == suggestedTitle } != null) {
            suggestedTitle = "$suggestedTitle $count"
            count += 1
        }
        return suggestedTitle
    }

    fun deleteGame(game: NumberPlateGame) {
        viewModelScope.launch {
            repository.deleteGame(game)
        }
    }

    private fun generatePlates(gameId: String): List<NumberPlate> {
        val plates = mutableListOf<NumberPlate>()
        NumberPlateType.values().forEach {
            plates.add(
                NumberPlate(
                    type = it, gameId = gameId
                )
            )
        }
        return plates
    }

    private fun getNewGameId() = System.currentTimeMillis().toString()

    companion object {
        private const val GUEST_ID = -1L
    }
}