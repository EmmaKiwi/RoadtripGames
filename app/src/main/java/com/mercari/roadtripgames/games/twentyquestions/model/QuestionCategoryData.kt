package com.mercari.roadtripgames.games.twentyquestions.model

enum class QuestionCategoryData(
    val id: Long,
    val title: String,
    val subTitle: String
) {
    ANIMAL(0, "Animal", "Generate a random animal"),
    PLANT(1, "Plant", "Generate a random plant"),
    MINERAL(2, "Mineral", "Something that isn't an animal or a plant"),
    PERSON(3, "Person", "A famous person, alive or dead"),
    BOOK(4, "Book", "A famous event from history"),
    EVENT(5, "Event", "A famous book"),
    MOVIE(6, "Movie", "A famous movie");

    fun toQuestionCategory() = QuestionCategory(
        id = id,
        title = title,
        subtitle = subTitle
    )
}