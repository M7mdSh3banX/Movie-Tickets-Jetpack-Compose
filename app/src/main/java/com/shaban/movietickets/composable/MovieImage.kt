package com.shaban.movietickets.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.shaban.movietickets.ui.theme.PrimaryColor

@Composable
fun MovieImage(
    data: String,
) {
    val painter = rememberAsyncImagePainter(model = data)
    val painterState = painter.state

    Image(
        painter = painter,
        contentDescription = "Movie Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth()
    )

    /*if (painterState is AsyncImagePainter.State.Loading) {
        CircularProgressIndicator(color = PrimaryColor)
    }*/
}