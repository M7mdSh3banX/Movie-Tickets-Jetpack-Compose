package com.shaban.movietickets.screen.tickets

data class TicketsUiState(
    val isAvailable: Boolean = false,
    val isTaken: Boolean = false,
    val isSelected: Boolean = false,
    val price: Double = 0.0,
    val numberOfTickets: Int = 0
)
