package com.shaban.movietickets.ui.bottom_navigation

import com.shaban.movietickets.R

sealed class BottomNavigation(
    val route: String,
    val title: String,
    val icon: Int,
) {

    object Home : BottomNavigation(
        route = "Home",
        title = "Home",
        icon = R.drawable.home_icon
    )

    object Search : BottomNavigation(
        route = "Search",
        title = "Search",
        icon = R.drawable.search_icon
    )

    object Ticket : BottomNavigation(
        route = "Ticket",
        title = "Ticket",
        icon = R.drawable.ticket_icon
    )

    object Profile : BottomNavigation(
        route = "Profile",
        title = "Profile",
        icon = R.drawable.person_icon
    )
}
