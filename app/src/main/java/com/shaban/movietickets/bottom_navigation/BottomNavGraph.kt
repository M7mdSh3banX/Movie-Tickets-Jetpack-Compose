package com.shaban.movietickets.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shaban.movietickets.screen.booking.BookingScreen
import com.shaban.movietickets.screen.home.HomeScreen

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
            HomeScreen()
        }
        composable(route = BottomNavigation.Profile.route) {
            BookingScreen()
        }
    }
}