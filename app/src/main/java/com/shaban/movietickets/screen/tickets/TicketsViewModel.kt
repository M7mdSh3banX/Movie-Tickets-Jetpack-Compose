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
        getTicketDetails()
    }

    private fun getTicketDate() {
        _state.update {
            it.copy(
                ticketDate = listOf(
                    TicketDateChipUiState(day = 14, dayName = "Thu"),
                    TicketDateChipUiState(day = 15, dayName = "Fri"),
                    TicketDateChipUiState(day = 16, dayName = "Sat"),
                    TicketDateChipUiState(day = 17, dayName = "Sun"),
                    TicketDateChipUiState(day = 18, dayName = "Mon"),
                    TicketDateChipUiState(day = 19, dayName = "Tue"),
                    TicketDateChipUiState(day = 20, dayName = "Wed"),
                    TicketDateChipUiState(day = 21, dayName = "Thu"),
                    TicketDateChipUiState(day = 22, dayName = "Fri"),
                    TicketDateChipUiState(day = 23, dayName = "Sat"),
                )
            )
        }
    }

    private fun getTicketTime() {
        _state.update {
            it.copy(
                ticketTime = listOf(
                    TicketTimeChipUiState(time = "10:00"),
                    TicketTimeChipUiState(time = "12:30"),
                    TicketTimeChipUiState(time = "15:30"),
                    TicketTimeChipUiState(time = "18:30"),
                    TicketTimeChipUiState(time = "21:30"),
                    TicketTimeChipUiState(time = "22:00"),
                    TicketTimeChipUiState(time = "00:00"),
                    TicketTimeChipUiState(time = "01:00"),
                    TicketTimeChipUiState(time = "02:00"),
                    TicketTimeChipUiState(time = "03:00"),
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

    fun onClickTimeChip(selectedDate: TicketTimeChipUiState) {
        _state.update { currentState ->
            val updatedDates = currentState.ticketTime.map { time ->
                if (time == selectedDate) {
                    time.copy(chipState = !time.chipState)
                } else {
                    time.copy(chipState = false)
                }
            }
            currentState.copy(ticketTime = updatedDates)
        }
    }

    private fun getTicketDetails() {
        _state.update {
            it.copy(
                price = 100.0,
                numberOfTickets = 4
            )
        }
    }
}