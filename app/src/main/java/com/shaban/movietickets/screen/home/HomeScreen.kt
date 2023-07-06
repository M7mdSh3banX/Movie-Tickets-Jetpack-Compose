package com.shaban.movietickets.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shaban.movietickets.composable.CustomChip
import com.shaban.movietickets.composable.MovieCardPager
import com.shaban.movietickets.composable.MovieDurationComponent
import com.shaban.movietickets.composable.MovieImageBackground
import com.shaban.movietickets.composable.MovieName
import com.shaban.movietickets.composable.MovieTag
import com.shaban.movietickets.screen.tickets.TicketDateChipUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(initialPage = 1)

    HomeContent(
        state = state,
        pagerState = pagerState,
        onClickMovieChip = viewModel::onClickDateChip
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    state: HomeUiState,
    pagerState: PagerState,
    onClickMovieChip: (MovieChipUiState) -> Unit
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
            MovieImageBackground(
                data = state.movieImages[pagerState.currentPage],
                color = Color.White
            )
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    CustomChip(movieChip = state.movieChip[0], onClick = onClickMovieChip)
                    CustomChip(movieChip = state.movieChip[1], onClick = onClickMovieChip)
                }
                Spacer(modifier = Modifier.height(16.dp))
                MovieCardPager(data = state.movieImages, state = pagerState)
            }
        }
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