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
        getCastImages()
        getMovieDescription()
    }

    private fun getMovieImage() =
        _state.update { it.copy(movieImage = "https://i.pinimg.com/564x/8b/7b/34/8b7b3481524411b38731d40d0644e5ca.jpg") }

    private fun getMovieDuration() =
        _state.update { it.copy(movieDuration = "2h 23m") }

    private fun getMovieName() =
        _state.update { it.copy(movieName = "Fantastic Beasts: The Secrets of Dumbledore") }

    private fun getMovieDescription() =
        _state.update { it.copy(movieDescription = "Professor Albus Dumbledore (Jude Law) knows the powerful Dark wizard Gellert Grindelwald (Mads Mikkelsen) is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts Magizoologist Newt Scamander (Eddie Redmayne) to lead an intrepid team of wizards, witches and one brave Muggle baker on a dangerous mission, where they encounter old and new beasts and clash with Grindelwald’s growing legion of followers. But with the stakes so high, how long can Dumbledore remain on the sidelines?") }

    private fun getCastImages() {
        _state.update {
            it.copy(
                movieCast = listOf(
                    "https://m.media-amazon.com/images/M/MV5BMTMwOTg5NTQ3NV5BMl5BanBnXkFtZTcwNzM3MDAzNQ@@._V1_UY109_CR1,0,75,109_AL_.jpg",
                    "https://m.media-amazon.com/images/M/MV5BYWM2ZDFkMDYtYzNhZC00ODhmLTgwMmUtYjUxNTAzYjM1ODBlXkEyXkFqcGdeQXVyMTI1NjU4MDIx._V1_UY109_CR6,0,75,109_AL_.jpg",
                    "https://m.media-amazon.com/images/M/MV5BMTcyMTU5MzgxMF5BMl5BanBnXkFtZTYwMDI0NjI1._V1_UX75_CR0,0,75,109_AL_.jpg",
                    "https://m.media-amazon.com/images/M/MV5BMTU0MjEyNzQyM15BMl5BanBnXkFtZTcwMTc4ODUxOQ@@._V1_UX75_CR0,0,75,109_AL_.jpg",
                    "https://m.media-amazon.com/images/M/MV5BMTU0OTIzNTY1OV5BMl5BanBnXkFtZTgwNjk4MzE2MDI@._V1_UX75_CR0,0,75,109_AL_.jpg",
                    "https://m.media-amazon.com/images/M/MV5BYzUxOGI2N2EtZDJkOS00YzhhLWE1NTItNjhkNGFiMDlmNzAzXkEyXkFqcGdeQXVyMzgwOTUxODU@._V1_UY109_CR41,0,75,109_AL_.jpg",
                    "https://m.media-amazon.com/images/M/MV5BMmQwMTE0NDUtOTUyYi00YmRhLWJhZTgtOWFjYzA5ZTM5YmE0XkEyXkFqcGdeQXVyMjQwMDg0Ng@@._V1_UY109_CR6,0,75,109_AL_.jpg",
                    "https://m.media-amazon.com/images/M/MV5BOTQ2YmNlZDEtM2EwNi00N2JhLTk3ZDktMjBmNzYwYWI1OWZmXkEyXkFqcGdeQXVyNjk1MjYyNTA@._V1_UX75_CR0,0,75,109_AL_.jpg",
                    "https://m.media-amazon.com/images/M/MV5BZmVlNGExOGMtYzA2Mi00MDFjLThiYzEtMTE3N2RkNDQwMzRkXkEyXkFqcGdeQXVyOTAyMDgxODQ@._V1_UY109_CR44,0,75,109_AL_.jpg",
                    "https://m.media-amazon.com/images/M/MV5BMTY5NTg4MDI3M15BMl5BanBnXkFtZTgwNzM2Mzc1MDI@._V1_UX75_CR0,0,75,109_AL_.jpg",
                )
            )
        }
    }
}