package com.shaban.movietickets.ui.composable.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieCardPager(
    data: List<String>,
    modifier: Modifier = Modifier,
    state: PagerState,
    onClickMovie: () -> Unit
) {
    HorizontalPager(
        pageCount = data.size,
        state = state,
        modifier = modifier.wrapContentSize(),
        contentPadding = PaddingValues(horizontal = 48.dp, vertical = 16.dp)
    ) { pageIndex ->
        Card(
            colors = CardDefaults.cardColors(Color.Transparent),
            modifier = modifier.clickable { onClickMovie() }
                .graphicsLayer {
                    val pageOffset =
                        ((state.currentPage - pageIndex) + state.currentPageOffsetFraction).absoluteValue
                    lerp(
                        start = ScaleFactor(0.85F, 0.85F),
                        stop = ScaleFactor(1F, 1F),
                        fraction = 1F - pageOffset.coerceIn(0F, 1F)
                    ).also { scale ->
                        scaleX = scale.scaleX
                        scaleY = scale.scaleY
                    }
                }
                .clip(RoundedCornerShape(32.dp))
                .fillMaxWidth()
                .aspectRatio(0.7F),
        ) {
            val painter = rememberAsyncImagePainter(model = data[pageIndex])

            Image(
                painter = painter,
                contentDescription = "Movie Image",
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewMovieCard() {

}