package com.shanks.fasalsaathi.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import com.shanks.fasalsaathi.R
import com.shanks.fasalsaathi.ui.theme.FasalSaathiTheme
import com.shanks.fasalsaathi.ui.theme.Green3


@Composable
fun TopImage(
    imageUrl : String? = "",
    imageTitle : String? = "Title"
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (imageUrl == null || imageUrl == ""){
            Image(
                painter = painterResource(id = R.drawable.crop_image),
                contentDescription = "Detailed_Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(20.dp)
                    .height(215.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
            )
        } else {
            SubcomposeAsyncImage(
                model = imageUrl,
                contentDescription = "Detail_Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(215.dp)
                    .clip(RoundedCornerShape(12.dp)),
                loading = {
                    CircularProgressIndicator(
                        color = Green3,
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DetailsComponent() {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopBar2(
            title = "Details",
            space = 100.dp,
            horizontalPadding = 12.dp
        )
        TopImage()
    }

}