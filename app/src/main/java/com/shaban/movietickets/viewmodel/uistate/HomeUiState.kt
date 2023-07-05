package com.shaban.movietickets.viewmodel.uistate

data class HomeUiState(
    val movieName: String = "",
    val movieDuration: String = "",
    val movieImages: List<String> = emptyList(),
)