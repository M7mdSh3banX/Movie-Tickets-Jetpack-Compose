package com.shaban.movietickets.ui.screen.movie_details

data class MovieDetailsUiState(
    val movieImage: String = "",
    val movieDuration: String = "",
    val imdbRating: Double = 0.0,
    val rottenTomatoesRating: Int = 0,
    val ignRating: Double = 0.0,
    val movieName: String = "",
    val movieCast: List<String> = emptyList(),
    val movieDescription: String = "",
    val movieTags: List<String> = emptyList()
)