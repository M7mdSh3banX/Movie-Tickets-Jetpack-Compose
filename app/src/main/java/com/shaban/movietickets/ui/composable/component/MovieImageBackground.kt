package com.shaban.movietickets.ui.composable.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.rememberAsyncImagePainter

@Composable
fun MovieImageBackground(
    data: String,
    modifier: Modifier = Modifier,
    color: Color
) {
    Box(modifier = Modifier
        .background(Color.White)
        .blur(24.dp)) {
        val painter = rememberAsyncImagePainter(model = data)

        Image(
            painter = painter,
            contentDescription = "Movie Image",
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1F)
                .background(brush = Brush.verticalGradient(listOf(Color.Transparent, color)))
        )
    }
}