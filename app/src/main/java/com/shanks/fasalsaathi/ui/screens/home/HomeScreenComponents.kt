package com.shanks.fasalsaathi.ui.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AcUnit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.shanks.fasalsaathi.R
import com.shanks.fasalsaathi.models.getCropPriceItemList
import com.shanks.fasalsaathi.ui.theme.FasalSaathiTheme
import com.shanks.fasalsaathi.ui.theme.Green4
import kotlinx.coroutines.delay


@Composable
fun IndicatorDot(
    modifier: Modifier = Modifier,
    size: Dp,
    color: Color
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(color)
    )
}

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color = Color.Yellow /* Color.Yellow */,
    unSelectedColor: Color = Color.Gray /* Color.Gray */,
    dotSize: Dp
) {
    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        items(totalDots) { index ->
            IndicatorDot(
                color = if (index == selectedIndex) selectedColor else unSelectedColor,
                size = dotSize
            )

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AutoSlidingCarousel(
    modifier: Modifier = Modifier,
    autoSlideDuration: Long = 3000L,
    pagerState: PagerState = remember { PagerState() },
    itemsCount: Int,
    itemContent: @Composable (index: Int) -> Unit,
) {
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    LaunchedEffect(pagerState.currentPage) {
        delay(autoSlideDuration)
        pagerState.animateScrollToPage((pagerState.currentPage + 1) % itemsCount)
    }

    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        HorizontalPager(count = itemsCount, state = pagerState) { page ->
            itemContent(page)
        }

        // you can remove the surface in case you don't want
        // the transparant bacground
        Surface(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter),
            shape = CircleShape,
            color = Color.Black.copy(alpha = 0.5f)
        ) {
            DotsIndicator(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                totalDots = itemsCount,
                selectedIndex = if (isDragged) pagerState.currentPage else pagerState.targetPage,
                dotSize = 8.dp
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CarousalCard() {
    val images = listOf(
        "https://res.cloudinary.com/dowpys11p/image/upload/v1/media/images/watermelon_ktnq0f",
        "https://res.cloudinary.com/dowpys11p/image/upload/v1/media/images/cucumber_lmofnm",
        "https://res.cloudinary.com/dowpys11p/image/upload/v1/media/images/soyabeans_bxbxwf",
        "https://res.cloudinary.com/dowpys11p/image/upload/v1/media/images/groundnut_amhbud"

    )

    val images2 = listOf(
        R.drawable.s1,
        R.drawable.s2,
        R.drawable.s3
    )

    Card(
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        AutoSlidingCarousel(
            itemsCount = images2.size,
            itemContent = { index ->
//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data(images[index])
//                        .build(),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.height(200.dp)
//                )
                Image(painter = painterResource(id = images2[index]),
                    contentDescription = "Scheme",
                    contentScale = if(index == 0) ContentScale.FillHeight else ContentScale.FillBounds,
                    modifier = Modifier.height(200.dp)
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUsCard(
     title : String? = "Feature",
     des : String? = "Lorem IPsum Bhot Sara kuch to hai yaha par",
     icon : ImageVector
) {
    OutlinedCard(
        modifier = Modifier
            .padding(6.dp)
            .size(110.dp),
        onClick = {

    }) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                modifier = Modifier.padding(top = 12.dp),
                contentDescription = "Icon")
            Text(text = title!!)

        }
        Text(
            text = des!!,
            fontSize = 8.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray)

    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeSubHeadings(title : String = "Market Prices") {
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center
//    ) {
//        OutlinedCard(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 20.dp),
//            onClick = {  },
//            colors = CardDefaults.cardColors(Green4)
//        ) {
//            Text(
//                text = "$title",
//                modifier = Modifier
//                    .padding(5.dp)
//                    .align(Alignment.CenterHorizontally),
//                style = MaterialTheme.typography.titleLarge,
//                color = Color.White,
//                fontWeight = FontWeight.W500
//            )
//        }
//    }
//    val cropListItems = getCropPriceItemList()
//    LazyRow(cropListItems) {
//
//    }
//}

@OptIn(ExperimentalPagerApi::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenComponentsPreview() {
    FasalSaathiTheme {
//        HomeSubHeadings()
    }
}