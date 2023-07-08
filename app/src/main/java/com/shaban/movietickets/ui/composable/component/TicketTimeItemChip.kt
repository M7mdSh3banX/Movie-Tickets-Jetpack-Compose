package com.shaban.movietickets.ui.composable.component

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shaban.movietickets.ui.screen.tickets.TicketTimeChipUiState
import com.shaban.movietickets.ui.theme.CardBackgroundColor

@Composable
fun TicketTimeItemChip(
    time: TicketTimeChipUiState,
    onClick: (TicketTimeChipUiState) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shadowElevation = 0.dp,
        shape = MaterialTheme.shapes.large,
        color = if (time.chipState) CardBackgroundColor else Color.Transparent,
        border = if (time.chipState) BorderStroke(width = 0.dp, color = Color.Transparent)
        else BorderStroke(
            width = 1.dp,
            color = Color.LightGray
        ),
    ) {
        Column(
            modifier = modifier
                .padding(8.dp)
                .clickable { onClick(time) },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = time.time,
                color = if (time.chipState) Color.White else Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
            )
        }
    }
}

@Preview
@Composable
fun PreviewTicketTimeItemChip() {
    TicketTimeItemChip(time = TicketTimeChipUiState("10:00", true), onClick = { })
}