package com.shaban.movietickets.screen.tickets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TicketsScreen(
    viewModel: TicketsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    TicketsContent(state = state)
}

@Composable
fun TicketsContent(
    state: TicketsUiState
) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTicketsScreen() {
    TicketsScreen()
}