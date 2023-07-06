package com.shaban.movietickets.composable.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.shaban.movietickets.R
import com.shaban.movietickets.ui.theme.WhiteE1

@Composable
fun MovieCastItem(
    data: String,
    modifier: Modifier = Modifier
) {
    val painter = rememberAsyncImagePainter(model = data)
    val painterState = painter.state

    Image(
        painter = painter,
        contentDescription = "Movie Cast Image",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(72.dp)
            .clip(CircleShape)
            .background(WhiteE1)
    )
}

@Preview
@Composable
fun PreviewMovieCastItem() {
    MovieCastItem(data = R.drawable.play_icon.toString())
}