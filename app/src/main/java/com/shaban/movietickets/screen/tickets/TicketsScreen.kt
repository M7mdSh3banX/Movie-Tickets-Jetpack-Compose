package com.shaban.movietickets.screen.tickets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shaban.movietickets.R
import com.shaban.movietickets.composable.BookingButton
import com.shaban.movietickets.composable.CinemaCover
import com.shaban.movietickets.composable.IconWithTransparentBackground
import com.shaban.movietickets.composable.RatingText
import com.shaban.movietickets.composable.RottenTomatoesRatingText
import com.shaban.movietickets.composable.TicketDateItemChip
import com.shaban.movietickets.composable.TicketDetails
import com.shaban.movietickets.composable.TicketTimeItemChip
import com.shaban.movietickets.ui.theme.NotoSans

@Composable
fun TicketsScreen(
    viewModel: TicketsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    TicketsContent(
        state = state,
        onClickDateChip = viewModel::onClickDateChip,
        onClickTimeChip = viewModel::onClickTimeChip
    )
}

@Composable
fun TicketsContent(
    state: TicketsUiState,
    onClickDateChip: (TicketDateChipUiState) -> Unit,
    onClickTimeChip: (TicketTimeChipUiState) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(200.dp)
        ) {
            IconWithTransparentBackground(icon = R.drawable.exit_icon)
            Spacer(modifier = Modifier.height(8.dp))
            CinemaCover(painter = painterResource(id = R.drawable.cinema_cover))
        }
        Spacer(modifier = Modifier.weight(1F))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White, shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 24.dp)
            ) {
                items(state.ticketDate) {
                    TicketDateItemChip(
                        date = TicketDateChipUiState(it.day, it.dayName, it.chipState),
                        onClick = onClickDateChip,
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 24.dp)
            ) {
                items(state.ticketTime) {
                    TicketTimeItemChip(
                        time = TicketTimeChipUiState(it.time, it.chipState),
                        onClick = onClickTimeChip
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1F))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TicketDetails(price = state.price, numberOfTickets = state.numberOfTickets)
                BookingButton(
                    buttonText = "Buy Tickets",
                    painter = painterResource(id = R.drawable.booking_icon),
                    onClickBooking = { /*TODO*/ },
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTicketsScreen() {
    TicketsScreen()
}