package com.shaban.movietickets.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shaban.movietickets.composable.CustomChip
import com.shaban.movietickets.composable.MovieCardPager
import com.shaban.movietickets.composable.MovieDurationComponent
import com.shaban.movietickets.composable.MovieImage
import com.shaban.movietickets.composable.MovieName
import com.shaban.movietickets.composable.MovieTag
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.6f)
        ) {
            MovieImage(data = state.movieImages[1], modifier = Modifier.blur(25.dp))
            Column {
                Spacer(modifier = Modifier.height(16.dp))
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
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MovieDurationComponent(movieDuration = "2h 23m", textColor = Color.Black)
            MovieName(name = "Fantastic Beasts: The Secrets of Dumbledore")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                MovieTag(name = "Fantasy")
                MovieTag(name = "Adventure")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}