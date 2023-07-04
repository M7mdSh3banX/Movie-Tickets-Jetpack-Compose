package com.shaban.movietickets.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shaban.movietickets.ui.theme.BorderColor
import com.shaban.movietickets.ui.theme.NotoSans

@Composable
fun MovieTag(
    name: String,
    modifier: Modifier = Modifier
) {
    Box(modifier.padding(horizontal = 4.dp)) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .border(width = 1.dp, color = BorderColor, shape = CircleShape)
        ) {
            Text(
                text = name,
                color = Color.Black,
                fontFamily = NotoSans,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = modifier.padding(horizontal = 12.dp, vertical = 4.dp),
            )
        }
    }

}

@Preview
@Composable
fun PreviewMovieTag() {
    MovieTag(name = "Fantasy")
}