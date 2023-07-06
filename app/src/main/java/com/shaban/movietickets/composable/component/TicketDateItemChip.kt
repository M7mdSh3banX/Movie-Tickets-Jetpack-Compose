package com.shaban.movietickets.composable.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import com.shaban.movietickets.screen.tickets.TicketDateChipUiState
import com.shaban.movietickets.ui.theme.CardBackgroundColor

@Composable
fun TicketDateItemChip(
    date: TicketDateChipUiState,
    onClick: (TicketDateChipUiState) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shadowElevation = 0.dp,
        shape = MaterialTheme.shapes.large,
        color = if (date.chipState) CardBackgroundColor else Color.Transparent,
        border = if (date.chipState) BorderStroke(width = 0.dp, color = Color.Transparent)
        else BorderStroke(
            width = 1.dp,
            color = Color.LightGray
        ),
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .clickable { onClick(date) },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = date.day.toString(),
                color = if (date.chipState) Color.White else Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp,
            )
            Text(
                text = date.dayName,
                color = if (date.chipState) Color.White else Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                modifier = modifier.alpha(0.8F)
            )
        }
    }
}

@Preview
@Composable
fun PreviewDateChip() {
    TicketDateItemChip(date = TicketDateChipUiState(14, "Thu", true), onClick = { })
}