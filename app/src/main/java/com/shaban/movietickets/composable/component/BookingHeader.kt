package com.shaban.movietickets.composable.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        IconWithTransparentBackground(icon = R.drawable.exit_icon)
        MovieDurationComponent(movieDuration = movieDuration, textColor = Color.White)
    }
}

@Preview()
@Composable
fun PreviewHeader() {
    BookingHeader(movieDuration = "2h 23m")
}