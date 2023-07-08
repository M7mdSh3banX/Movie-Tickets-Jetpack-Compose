package com.shaban.movietickets.ui.composable.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shaban.movietickets.R
import com.shaban.movietickets.ui.theme.PrimaryColor

@Composable
fun PlayMovie(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(PrimaryColor),
        contentPadding = PaddingValues(0.dp),
        modifier = modifier.size(64.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.play_icon),
            contentDescription = "Icon Play",
            tint = Color.White
        )
    }
}