package com.shaban.movietickets.ui.screen.composable.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shaban.movietickets.R
import com.shaban.movietickets.ui.theme.PrimaryColor

@Composable
fun CustomButton(
    buttonText: String,
    painter: Painter,
    onClickBooking: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClickBooking,
        shape = MaterialTheme.shapes.extraLarge,
        colors = ButtonDefaults.buttonColors(PrimaryColor),
    ) {
        Icon(
            painter = painter,
            contentDescription = "Booking Icon",
            modifier = modifier.size(24.dp)
        )
        Spacer(modifier = modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text = buttonText,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun PreviewBookingButton() {
    CustomButton(
        buttonText = "Booking",
        onClickBooking = { /*TODO*/ },
        painter = painterResource(id = R.drawable.booking_icon)
    )
}