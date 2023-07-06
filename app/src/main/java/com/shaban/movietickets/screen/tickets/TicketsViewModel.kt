package com.shaban.movietickets.screen.tickets

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class TicketsViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(TicketsUiState())
    val state = _state.asStateFlow()

}