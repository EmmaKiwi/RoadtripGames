package com.mercari.roadtripgames.games.twentyquestions.data

import com.mercari.roadtripgames.games.twentyquestions.model.Movie

class MovieData {
    companion object {
        fun getMovies(categoryId: Long) = listOf(
            Movie(
                categoryId = categoryId,
                name = "The Lion King",
                genre = "Family",
                description = "Animated movie",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "The Shawshank Redemption",
                genre = "Drama",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Oceans 11",
                genre = "Thriller",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "50 First Dates",
                genre = "Romance",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Tenet",
                genre = "Thriller",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Home Alone",
                genre = "Family",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Snow White and the 7 Dwarves",
                genre = "Family",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Moana",
                genre = "Family",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Mulan",
                genre = "Family",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Citizen Kane",
                genre = "",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "The Avengers",
                genre = "",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "The Godfather",
                genre = "",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Star Wars: Return of the Jedi",
                genre = "",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Lord of the Rings: The Fellowship of the Ring",
                genre = "",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Planet of the Apes",
                genre = "",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Casino Royal",
                genre = "",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "A Quiet Place",
                genre = "Horror",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "The Silence of the Lambs",
                genre = "Horror",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Rosemary's Baby",
                genre = "Horror",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "The Wizard of Oz",
                genre = "Family",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Singin' in the Rain",
                genre = "Romance",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "2001: A Space Odyssey",
                genre = "SciFi",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Alien",
                genre = "Horror/Action",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Looper",
                genre = "SciFi",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "Casablanca",
                genre = "Romance",
                description = "",
                releaseDate = 0
            ),
            Movie(
                categoryId = categoryId,
                name = "The Princess Bride",
                genre = "Romance",
                description = "",
                releaseDate = 0
            )
        )
    }
}