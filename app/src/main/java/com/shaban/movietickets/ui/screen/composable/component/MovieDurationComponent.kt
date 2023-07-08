package com.shaban.movietickets.ui.screen.composable.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shaban.movietickets.R

@Composable
fun MovieDurationComponent(
    movieDuration: String,
    modifier: Modifier = Modifier,
    textColor: Color
) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(14.dp))
            .padding(6.dp)
            .background(
                shape = CircleShape,
                color = Color.White.copy(alpha = 0.4F)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = modifier.padding(vertical = 6.dp, horizontal = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.clock_icon),
                contentDescription = "content description",
                modifier = modifier.size(ButtonDefaults.IconSize),
                tint = Color.LightGray
            )
            Text(
                text = movieDuration,
                color = textColor,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = modifier
            )
        }
    }
}