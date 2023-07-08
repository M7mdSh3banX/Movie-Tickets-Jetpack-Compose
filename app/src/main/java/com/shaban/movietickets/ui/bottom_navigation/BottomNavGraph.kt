package com.shaban.movietickets.ui.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shaban.movietickets.ui.screen.booking.BookingScreen
import com.shaban.movietickets.ui.screen.home.HomeScreen
import com.shaban.movietickets.ui.screen.tickets.TicketsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigation.Home.route
    ) {
        composable(route = BottomNavigation.Home.route) {
            HomeScreen()
        }
        composable(route = BottomNavigation.Search.route) {
            BookingScreen()
        }
        composable(route = BottomNavigation.Ticket.route) {
            TicketsScreen()
        }
        composable(route = BottomNavigation.Profile.route) {

        }
    }
}