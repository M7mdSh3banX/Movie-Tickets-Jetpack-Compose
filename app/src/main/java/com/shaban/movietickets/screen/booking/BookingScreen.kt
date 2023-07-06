package com.shaban.movietickets.screen.booking

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shaban.movietickets.R
import com.shaban.movietickets.composable.component.BookingHeader
import com.shaban.movietickets.composable.component.CustomButton
import com.shaban.movietickets.composable.component.MovieCastItem
import com.shaban.movietickets.composable.component.MovieDescription
import com.shaban.movietickets.composable.component.MovieImage
import com.shaban.movietickets.composable.component.MovieName
import com.shaban.movietickets.composable.component.MovieTag
import com.shaban.movietickets.composable.component.PlayMovie
import com.shaban.movietickets.composable.component.RatingText
import com.shaban.movietickets.composable.component.RottenTomatoesRatingText
import com.shaban.movietickets.composable.spacing.SpacerVertical16
import com.shaban.movietickets.composable.spacing.SpacerVertical4

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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
        ) {
            MovieImage(data = state.movieImage)
            BookingHeader(movieDuration = state.movieDuration)
            Box(modifier = Modifier.align(Alignment.Center)) {
                PlayMovie {}
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.6f)
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
                RatingText(rating = state.imdbRating, text = stringResource(R.string.imdb))
                RottenTomatoesRatingText(
                    rating = state.rottenTomatoesRating,
                    text = stringResource(R.string.rotten_tomatoes)
                )
                RatingText(rating = state.ignRating, text = stringResource(R.string.ign))
            }
            MovieName(name = state.movieName)
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                items(state.movieTags) { tag ->
                    MovieTag(name = tag)
                }
            }
            SpacerVertical4()
            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(state.movieCast) { image ->
                    MovieCastItem(data = image)
                }
            }
            SpacerVertical4()
            MovieDescription(description = state.movieDescription)
            SpacerVertical4()
            Spacer(modifier = Modifier.weight(1F))
            CustomButton(
                buttonText = stringResource(R.string.booking),
                painter = painterResource(id = R.drawable.booking_icon),
                onClickBooking = { },
                modifier = Modifier
            )
            SpacerVertical16()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewBookingScreen() {
    BookingScreen()
}