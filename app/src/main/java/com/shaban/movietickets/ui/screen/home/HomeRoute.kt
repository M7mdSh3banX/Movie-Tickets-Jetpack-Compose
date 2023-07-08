package com.shaban.movietickets.ui.screen.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.shaban.movietickets.ui.bottom_navigation.BottomNavigation

fun NavGraphBuilder.homeRoute(
    navController: NavHostController,
) {
    composable(route = BottomNavigation.Home.route) {
        HomeScreen(navController)
    }
}