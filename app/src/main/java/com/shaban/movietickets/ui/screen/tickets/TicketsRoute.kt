package com.shaban.movietickets.ui.screen.tickets


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.shaban.movietickets.ui.bottom_navigation.BottomNavigation

fun NavController.navigateToTickets() {
    navigate(BottomNavigation.Ticket.route)
}

fun NavGraphBuilder.ticketsRoute(
    navController: NavHostController,
) {
    composable(route = BottomNavigation.Ticket.route) {
        TicketsScreen(navController)
    }
}