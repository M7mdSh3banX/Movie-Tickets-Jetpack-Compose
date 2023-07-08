package com.shaban.movietickets.ui.screen.composable.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

@Composable
fun CinemaCover(
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painter,
        contentDescription = "Movie Image",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()
            .alpha(0.7F)
    )
}