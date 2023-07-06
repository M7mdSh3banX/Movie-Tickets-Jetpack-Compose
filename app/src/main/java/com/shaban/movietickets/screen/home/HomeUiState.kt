package com.shaban.movietickets.screen.home

data class HomeUiState(
    val movieName: String = "",
    val movieDuration: String = "",
    val movieImages: List<String> = emptyList(),
    val movieChip: List<MovieChipUiState> = emptyList(),
)

data class MovieChipUiState(
    val title: String = "",
    val chipState: Boolean
)