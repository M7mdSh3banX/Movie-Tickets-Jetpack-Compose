package com.shaban.movietickets.ui.composable.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shaban.movietickets.R

@Composable
fun TicketSeatChip(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SeatState(0)
        SeatState(1)
        SeatState(2)
    }
}

@Composable
fun SeatState(
    seatPosition: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = when (seatPosition) {
            0 -> painterResource(id = R.drawable.left_seat)
            1 -> painterResource(id = R.drawable.center_seat)
            else -> painterResource(id = R.drawable.right_seat)
        },
        contentDescription = "Seat Icon",
        modifier = modifier.size(90.dp),
    )
}