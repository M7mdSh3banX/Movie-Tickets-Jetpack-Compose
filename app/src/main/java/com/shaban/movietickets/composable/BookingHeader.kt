package com.shaban.movietickets.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shaban.movietickets.R
import com.shaban.movietickets.ui.theme.NotoSans

@Composable
fun BookingHeader(
    movieDuration: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically
    ) {

        IconButton(
            onClick = { }
        ) {
            Icon(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.exit),
                contentDescription = "Exit From Booking",
                tint = Color.White
            )
        }

        Box(
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(14.dp))
                .padding(6.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.access_time),
                    contentDescription = "content description",
                    modifier = Modifier.size(14.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = movieDuration,
                    color = Color.White,
                    fontFamily = NotoSans,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    modifier = modifier
                )
            }

        }
    }
}

@Preview()
@Composable
fun PreviewHeader() {
    BookingHeader(movieDuration = "2h 23m")
}