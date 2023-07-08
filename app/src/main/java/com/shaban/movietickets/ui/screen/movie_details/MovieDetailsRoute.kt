package com.shaban.movietickets.ui.screen.movie_details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

private const val ROUTE = "MovieDetailsRoute"

fun NavController.navigateToMovieDetails() {
    navigate(ROUTE)
}

fun NavGraphBuilder.movieDetailsRoute(
    navController: NavHostController,
) {
    composable(route = ROUTE) {
        MovieDetailsScreen(navController)
    }
}