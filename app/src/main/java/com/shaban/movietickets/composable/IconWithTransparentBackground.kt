package com.shaban.movietickets.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shaban.movietickets.R

@Composable
fun IconWithTransparentBackground(
    modifier: Modifier = Modifier,
    icon: Int
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
            painter = painterResource(id = icon),
            contentDescription = "Icon",
            tint = Color.White
        )
    }
}

@Preview
@Composable
fun PreviewIconWithTransparentBackground() {
    IconWithTransparentBackground(icon = R.drawable.exit_icon)
}