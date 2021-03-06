package com.mercari.roadtripgames.games.twentyquestions.data

import com.mercari.roadtripgames.games.twentyquestions.model.Person

class PeopleData {

    enum class PeopleCategories(val subCatgoryId: Long) {
        SPORTS(0),
        ACTOR(1),
        POLITICIAN(2),
        FICTIONAL(3),
        ARTIST(4)
    }

    companion object {
        fun getPeople(categoryId: Long) = getSportsPeople()

        fun getSportsPeople() = listOf(
            createSportsPerson(
                name = "Roger Federer",
                description = "Tennis Player",
                country = "Switzerland",
                dateOfBirth = ""
            ),
            createSportsPerson(
                name = "Serena Williams",
                description = "Tennis Player",
                country = "USA",
                dateOfBirth = ""
            ),
            createSportsPerson(
                name = "Maria Sharapova",
                description = "Tennis Player",
                country = "Russia",
                dateOfBirth = ""
            ),
            createSportsPerson(
                name = "Naomi Osaka",
                description = "Tennis Player",
                country = "Japan",
                dateOfBirth = ""
            ),
            createSportsPerson(
                name = "Michael Jordan",
                description = "Basket ball Player",
                country = "USA",
                dateOfBirth = ""
            ),
            createSportsPerson(
                name = "LeBron James",
                description = "Basket ball Player",
                country = "USA",
                dateOfBirth = ""
            ),
            createSportsPerson(
                name = "Tiger Woods",
                description = "Golf Player",
                country = "America",
                dateOfBirth = ""
            ),
            createSportsPerson(
                name = "Cristiano Ronaldo",
                description = "Football Player",
                country = "Portugal",
                dateOfBirth = ""
            ),
            createSportsPerson(
                name = "Lionel Messi",
                description = "Football Player",
                country = "Argentina",
                dateOfBirth = ""
            ),
            createSportsPerson(
                name = "Usain Bolt",
                description = "Runner",
                country = "Jamaica",
                dateOfBirth = ""
            ),
            createSportsPerson(
                name = "Simone Biles",
                description = "Gymnast",
                country = "USA",
                dateOfBirth = ""
            ),
            createSportsPerson(
                name = "Ronda Rousey",
                description = "Wrestler",
                country = "USA",
                dateOfBirth = ""
            )
        )

        fun createSportsPerson(
            name: String,
            description: String,
            country: String,
            dateOfBirth: String
        ) = Person(
            name = name,
            description = description,
            country = country,
            dateOfBirth = dateOfBirth,
            subCategoryId = PeopleCategories.SPORTS.subCatgoryId
        )
    }
}