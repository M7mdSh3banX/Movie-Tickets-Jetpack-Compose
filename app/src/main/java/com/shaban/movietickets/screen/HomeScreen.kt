package com.shaban.movietickets.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shaban.movietickets.composable.CustomChip
import com.shaban.movietickets.composable.MovieCardPager
import com.shaban.movietickets.viewmodel.HomeViewModel
import com.shaban.movietickets.viewmodel.uistate.HomeUiState

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    HomeContent(state = state)
}

@Composable
fun HomeContent(
    state: HomeUiState
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                CustomChip(text = "Coming Soon", onSelectedChipChanged = {})
                CustomChip(text = "Now Showing", onSelectedChipChanged = {}, isSelected = true)
            }
            Spacer(modifier = Modifier.height(16.dp))
            MovieCardPager(data = state.movieImages)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f)
        ) {

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}