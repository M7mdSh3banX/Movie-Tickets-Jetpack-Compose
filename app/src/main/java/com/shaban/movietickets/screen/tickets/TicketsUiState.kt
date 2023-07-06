package com.shaban.movietickets.screen.tickets

data class TicketsUiState(
    val isAvailable: Boolean = false,
    val isTaken: Boolean = false,
    val isSelected: Boolean = false,
    val ticketDate: List<TicketDateChipUiState> = emptyList(),
    val ticketTime: List<TicketTimeChipUiState> = emptyList(),
    val price: Double = 0.0,
    val numberOfTickets: Int = 0
)

data class TicketDateChipUiState(
    val day: Int = 1,
    val dayName: String = "",
    val chipState: Boolean
)

data class TicketTimeChipUiState(
    val time: String = "",
    val chipState: Boolean
)