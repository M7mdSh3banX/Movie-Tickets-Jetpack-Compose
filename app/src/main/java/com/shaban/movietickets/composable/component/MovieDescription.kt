package com.shaban.movietickets.composable.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shaban.movietickets.ui.theme.NotoSans

@Composable
fun MovieDescription(
    description: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = description,
            color = Color.Black,
            fontFamily = NotoSans,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp).alpha(0.8F),
            textAlign = TextAlign.Center,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMovieDescription() {
    MovieDescription(description = "Professor Albus Dumbledore (Jude Law) knows the powerful Dark wizard Gellert Grindelwald (Mads Mikkelsen) is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts Magizoologist Newt Scamander (Eddie Redmayne) to lead an intrepid team of wizards, witches and one brave Muggle baker on a dangerous mission, where they encounter old and new beasts and clash with Grindelwald’s growing legion of followers. But with the stakes so high, how long can Dumbledore remain on the sidelines?")
}