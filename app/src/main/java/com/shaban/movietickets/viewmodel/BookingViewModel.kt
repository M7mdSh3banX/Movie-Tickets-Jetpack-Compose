package com.shaban.movietickets.viewmodel

import androidx.lifecycle.ViewModel
import com.shaban.movietickets.viewmodel.uistate.BookingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(BookingUiState())
    val state = _state.asStateFlow()

    init {
        getMovieImage()
        getMovieDuration()
        getMovieName()
    }

    private fun getMovieImage() =
        _state.update { it.copy(movieImage = "https://i.pinimg.com/564x/8b/7b/34/8b7b3481524411b38731d40d0644e5ca.jpg") }

    private fun getMovieDuration() =
        _state.update { it.copy(movieDuration = "2h 23m") }

    private fun getMovieName() =
        _state.update { it.copy(movieName = "Fantastic Beasts: The Secrets of Dumbledore") }
}