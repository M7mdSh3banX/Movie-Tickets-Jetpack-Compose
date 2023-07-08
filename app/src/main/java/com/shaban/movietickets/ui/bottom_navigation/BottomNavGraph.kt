package com.shaban.movietickets.ui.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shaban.movietickets.ui.screen.home.homeRoute
import com.shaban.movietickets.ui.screen.movie_details.movieDetailsRoute
import com.shaban.movietickets.ui.screen.tickets.ticketsRoute

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigation.Home.route
    ) {
        homeRoute(navController)
        composable(route = BottomNavigation.Search.route) { }
        ticketsRoute(navController)
        composable(route = BottomNavigation.Profile.route) { }
        movieDetailsRoute(navController)
    }
}