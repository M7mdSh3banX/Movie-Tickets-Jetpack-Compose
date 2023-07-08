package com.shaban.movietickets.ui.screen.tickets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.shaban.movietickets.R
import com.shaban.movietickets.ui.composable.component.CinemaCover
import com.shaban.movietickets.ui.composable.component.CustomButton
import com.shaban.movietickets.ui.composable.component.IconWithTransparentBackground
import com.shaban.movietickets.ui.composable.component.TicketDateItemChip
import com.shaban.movietickets.ui.composable.component.TicketDetails
import com.shaban.movietickets.ui.composable.component.TicketSeatChip
import com.shaban.movietickets.ui.composable.component.TicketSeatState
import com.shaban.movietickets.ui.composable.component.TicketTimeItemChip
import com.shaban.movietickets.ui.composable.spacing.SpacerVertical16
import com.shaban.movietickets.ui.composable.spacing.SpacerVertical24
import com.shaban.movietickets.ui.composable.spacing.SpacerVertical8
import com.shaban.movietickets.ui.theme.PrimaryColor
import com.shaban.movietickets.ui.theme.SeatColor

@Composable
fun TicketsScreen(
    navController: NavHostController,
    viewModel: TicketsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    TicketsContent(
        state = state,
        onClickDateChip = viewModel::onClickDateChip,
        onClickTimeChip = viewModel::onClickTimeChip,
        onClickExit = { navController.navigateUp() }
    )
}

@Composable
fun TicketsContent(
    state: TicketsUiState,
    onClickDateChip: (TicketDateChipUiState) -> Unit,
    onClickTimeChip: (TicketTimeChipUiState) -> Unit,
    onClickExit: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
    ) {
        Column(
            modifier = Modifier
                .weight(0.7F)
                .fillMaxWidth()
                .padding(top = 28.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
        ) {
            IconWithTransparentBackground(icon = R.drawable.exit_icon, onClick = onClickExit)
            SpacerVertical8()
            CinemaCover(painter = painterResource(id = R.drawable.cinema_cover))

            TicketSeatChip()
            TicketSeatChip()
            TicketSeatChip()

            Spacer(modifier = Modifier.weight(1F))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TicketSeatState(text = stringResource(R.string.available), color = White)
                TicketSeatState(text = stringResource(R.string.taken), color = SeatColor)
                TicketSeatState(text = stringResource(R.string.selected), color = PrimaryColor)
            }
        }
        Column(
            modifier = Modifier
                .weight(0.4F)
                .fillMaxWidth()
                .background(White, shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerVertical24()
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
            SpacerVertical24()
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
                CustomButton(
                    buttonText = stringResource(R.string.buy_tickets),
                    painter = painterResource(id = R.drawable.booking_icon),
                    onClickBooking = { },
                    modifier = Modifier
                )
            }
            SpacerVertical16()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTicketsScreen() {

}