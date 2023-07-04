package com.shaban.movietickets.screen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.shaban.movietickets.composable.BookingHeader
import com.shaban.movietickets.composable.MovieCastItem
import com.shaban.movietickets.composable.MovieDescription
import com.shaban.movietickets.composable.MovieImage
import com.shaban.movietickets.composable.MovieName
import com.shaban.movietickets.composable.MovieTag
import com.shaban.movietickets.composable.PlayMovie
import com.shaban.movietickets.composable.RatingText
import com.shaban.movietickets.composable.RottenTomatoesRatingText
import com.shaban.movietickets.viewmodel.BookingViewModel
import com.shaban.movietickets.viewmodel.uistate.BookingUiState

@Composable
fun BookingScreen(viewModel: BookingViewModel = hiltViewModel()) {
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
                .weight(1f),
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RatingText(rating = 6.8, text = "IMDb")
                RottenTomatoesRatingText(rating = 63, text = "Rotten Tomatoes")
                RatingText(rating = 4.0, text = "IGN")
            }
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
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(state.movieCast) { image ->
                    MovieCastItem(data = image)
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            MovieDescription(description = state.movieDescription)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewBookingScreen() {
    BookingScreen()
}