package com.shaban.movietickets.screen.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getMovieImages()
        getMovieChips()
        getMovieName()
        getMovieDuration()
        getMovieTags()
    }

    private fun getMovieImages() {
        _state.update {
            it.copy(
                movieImages = listOf(
                    "https://i.pinimg.com/564x/f4/45/3a/f4453ae53e13583d7d1765cb2e1d578a.jpg",
                    "https://i.pinimg.com/564x/eb/ff/3a/ebff3aaabeb4b06c312be11479eae23b.jpg",
                    "https://i.pinimg.com/564x/24/ce/49/24ce4933b8fbec020cb7ff0f23b1cf62.jpg"
                )
            )
        }
    }

    private fun getMovieChips() {
        _state.update {
            it.copy(
                movieChip = listOf(
                    MovieChipUiState(title = "Coming Soon", chipState = true),
                    MovieChipUiState(title = "Now Showing", chipState = false)
                )
            )
        }
    }

    fun onClickDateChip(selectedChip: MovieChipUiState) {
        _state.update { currentState ->
            val updatedDates = currentState.movieChip.map { date ->
                if (date == selectedChip) {
                    date.copy(chipState = true)
                } else {
                    date.copy(chipState = false)
                }
            }
            currentState.copy(movieChip = updatedDates)
        }
    }

    private fun getMovieName() {
        _state.update {
            it.copy(
                movieName = "Fantastic Beasts: The Secrets of Dumbledore"
            )
        }
    }

    private fun getMovieDuration() {
        _state.update {
            it.copy(
                movieDuration = "2h 23m"
            )
        }
    }

    private fun getMovieTags() {
        _state.update { it.copy(movieTag = listOf("Fantasy", "Adventure")) }
    }
}