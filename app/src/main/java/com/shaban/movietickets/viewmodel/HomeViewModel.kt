package com.shaban.movietickets.viewmodel

import androidx.lifecycle.ViewModel
import com.shaban.movietickets.viewmodel.uistate.HomeUiState
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
}