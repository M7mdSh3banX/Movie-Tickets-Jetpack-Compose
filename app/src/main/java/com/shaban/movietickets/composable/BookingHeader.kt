package com.shaban.movietickets.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shaban.movietickets.R

@Composable
fun BookingHeader(
    movieDuration: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically
    ) {

        IconButton(
            onClick = { },
            modifier = modifier
                .background(
                    shape = CircleShape,
                    color = Color.White.copy(alpha = 0.4F)
                )
                .size(40.dp)
        ) {
            Icon(
                modifier = modifier.size(24.dp),
                painter = painterResource(id = R.drawable.exit_icon),
                contentDescription = "Exit From Booking",
                tint = Color.White
            )
        }
        MovieDurationComponent(movieDuration = movieDuration, textColor = Color.White)
    }
}

@Preview()
@Composable
fun PreviewHeader() {
    BookingHeader(movieDuration = "2h 23m")
}