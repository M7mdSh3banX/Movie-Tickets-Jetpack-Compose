package com.shaban.movietickets.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.shaban.movietickets.ui.theme.NotoSans

@Composable
fun RottenTomatoesRatingText(
    rating: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "$rating%",
            color = Color.Black,
            fontFamily = NotoSans,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = modifier
        )
        Text(
            text = text,
            color = Color.LightGray,
            fontFamily = NotoSans,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            modifier = modifier
        )
    }
}

@Preview()
@Composable
fun PreviewRottenTomatoesRatingText() {
    RottenTomatoesRatingText(rating = 63, "Rotten Tomatoes")
}