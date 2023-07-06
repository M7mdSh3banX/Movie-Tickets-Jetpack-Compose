package com.shaban.movietickets.composable.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.shaban.movietickets.ui.theme.NotoSans

@Composable
fun TicketDetails(
    price: Double,
    numberOfTickets: Int,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = "$$price",
            color = Color.Black,
            fontFamily = NotoSans,
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            modifier = Modifier,
            textAlign = TextAlign.Center
        )
        Text(
            text = "$numberOfTickets tickets",
            color = Color.Black,
            fontFamily = NotoSans,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            modifier = Modifier,
            textAlign = TextAlign.Center
        )
    }
}
