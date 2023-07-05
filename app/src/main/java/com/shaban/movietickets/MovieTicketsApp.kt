package com.shaban.movietickets

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.shaban.movietickets.bottom_navigation.BottomNavGraph
import com.shaban.movietickets.bottom_navigation.BottomNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTicketsApp() {
    val navController = rememberNavController()

    Scaffold(
        //modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            BottomNavGraph(navController = navController)
        }
    }
}