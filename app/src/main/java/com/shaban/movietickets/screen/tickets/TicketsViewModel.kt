package com.shaban.movietickets.screen.tickets

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TicketsViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(TicketsUiState())
    val state = _state.asStateFlow()

    init {
        getTicketDate()
        getTicketTime()
    }

    private fun getTicketDate() {
        _state.update {
            it.copy(
                ticketDate = listOf(
                    TicketDateChipUiState(day = 14, dayName = "Thu", chipState = false),
                    TicketDateChipUiState(day = 15, dayName = "Fri", chipState = false),
                    TicketDateChipUiState(day = 16, dayName = "Sat", chipState = false),
                    TicketDateChipUiState(day = 17, dayName = "Sun", chipState = false),
                    TicketDateChipUiState(day = 18, dayName = "Mon", chipState = false),
                    TicketDateChipUiState(day = 19, dayName = "Tue", chipState = false),
                    TicketDateChipUiState(day = 20, dayName = "Wed", chipState = false),
                    TicketDateChipUiState(day = 21, dayName = "Thu", chipState = false),
                    TicketDateChipUiState(day = 22, dayName = "Fri", chipState = false),
                    TicketDateChipUiState(day = 23, dayName = "Sat", chipState = false),
                )
            )
        }
    }

    private fun getTicketTime() {
        _state.update {
            it.copy(
                ticketTime = listOf(
                    TicketTimeChipUiState(time = "10:00", chipState = true),
                    TicketTimeChipUiState(time = "12:30", chipState = false),
                    TicketTimeChipUiState(time = "15:30", chipState = false),
                    TicketTimeChipUiState(time = "18:30", chipState = false),
                    TicketTimeChipUiState(time = "21:30", chipState = false),
                    TicketTimeChipUiState(time = "22:00", chipState = false),
                    TicketTimeChipUiState(time = "00:00", chipState = false),
                )
            )
        }
    }

    fun onClickDateChip(selectedDate: TicketDateChipUiState) {
        _state.update { currentState ->
            val updatedDates = currentState.ticketDate.map { date ->
                if (date == selectedDate) {
                    date.copy(chipState = !date.chipState)
                } else {
                    date.copy(chipState = false)
                }
            }
            currentState.copy(ticketDate = updatedDates)
        }
    }
}