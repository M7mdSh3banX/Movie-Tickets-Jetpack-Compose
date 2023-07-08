package com.shaban.movietickets.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavHostController
import com.shaban.movietickets.ui.bottom_navigation.BottomNavigation
import com.shaban.movietickets.ui.composable.component.*
import com.shaban.movietickets.ui.composable.spacing.*
import com.shaban.movietickets.ui.screen.movie_details.navigateToMovieDetails

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(initialPage = 1)

    HomeContent(
        state = state,
        pagerState = pagerState,
        onClickMovieChip = viewModel::onClickDateChip,
        onClickMovie = { navController.navigateToMovieDetails() }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    state: HomeUiState,
    pagerState: PagerState,
    onClickMovieChip: (MovieChipUiState) -> Unit,
    onClickMovie: () -> Unit
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
            Column(modifier = Modifier.padding(top = 28.dp)) {
                SpacerVertical16()
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    items(state.movieChip) { movieChip ->
                        CustomChip(movieChip = movieChip, onClick = onClickMovieChip)
                    }
                }
                SpacerVertical16()
                MovieCardPager(
                    data = state.movieImages,
                    state = pagerState,
                    onClickMovie = onClickMovie
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MovieDurationComponent(movieDuration = state.movieDuration, textColor = Color.Black)
            MovieName(name = state.movieName)
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                items(state.movieTag) { movieTag ->
                    MovieTag(name = movieTag)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {

}