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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shaban.movietickets.R
import com.shaban.movietickets.composable.BookingButton
import com.shaban.movietickets.composable.BookingHeader
import com.shaban.movietickets.composable.MovieCastItem
import com.shaban.movietickets.composable.MovieDescription
import com.shaban.movietickets.composable.MovieImage
import com.shaban.movietickets.composable.MovieName
import com.shaban.movietickets.composable.MovieTag
import com.shaban.movietickets.composable.PlayMovie
import com.shaban.movietickets.composable.RatingText
import com.shaban.movietickets.composable.RottenTomatoesRatingText

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
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            Spacer(modifier = Modifier.weight(1F))
            BookingButton(
                buttonText = "Booking",
                painter = painterResource(id = R.drawable.booking_icon),
                onClickBooking = { /*TODO*/ },
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewBookingScreen() {
    BookingScreen()
}