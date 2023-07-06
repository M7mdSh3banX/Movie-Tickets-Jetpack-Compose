package com.shaban.movietickets.composable.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shaban.movietickets.screen.home.MovieChipUiState
import com.shaban.movietickets.ui.theme.PrimaryColor

@Composable
fun CustomChip(
    movieChip: MovieChipUiState,
    onClick: (MovieChipUiState) -> Unit,
) {
    Surface(
        modifier = Modifier.padding(end = 8.dp),
        shadowElevation = 0.dp,
        shape = MaterialTheme.shapes.extraLarge,
        color = if (movieChip.chipState) PrimaryColor else Transparent,
        border = if (movieChip.chipState) BorderStroke(
            width = 0.dp,
            color = Transparent
        ) else BorderStroke(
            width = 1.dp,
            color = LightGray
        )
    ) {
        Row(
            modifier = Modifier.clickable { onClick(movieChip) }
        ) {
            Text(
                text = movieChip.title,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}