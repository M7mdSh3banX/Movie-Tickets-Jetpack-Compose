package com.shaban.movietickets.ui.composable.component

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
    modifier: Modifier = Modifier
) {
    val painter = rememberAsyncImagePainter(model = data)

    Image(
        painter = painter,
        contentDescription = "Movie Image",
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth()
    )
}