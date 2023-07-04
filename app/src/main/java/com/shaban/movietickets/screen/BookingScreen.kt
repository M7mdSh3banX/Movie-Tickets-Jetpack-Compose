package com.shaban.movietickets.screen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.shaban.movietickets.composable.BookingHeader
import com.shaban.movietickets.composable.MovieImage
import com.shaban.movietickets.composable.PlayMovie
import com.shaban.movietickets.viewmodel.BookingUiState
import com.shaban.movietickets.viewmodel.BookingViewModel

@Composable
fun BookingScreen(
    viewModel: BookingViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    BookingScreenContent(state = state)
}

@Composable
private fun BookingScreenContent(
    state: BookingUiState
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.9f),
        ) {
            val playButton = createRef()

            MovieImage(data = state.movieImage)
            BookingHeader(movieDuration = state.movieDuration)
            PlayMovie(
                modifier = Modifier.constrainAs(playButton) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) { }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.2f),
            contentAlignment = Alignment.Center
        ) {
            MovieImage(data = state.movieImage)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewBookingScreen() {
    BookingScreen()
}