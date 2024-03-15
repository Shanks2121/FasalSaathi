

package com.shanks.fasalsaathi.ui.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil.compose.SubcomposeAsyncImage
import com.shanks.fasalsaathi.R
import com.shanks.fasalsaathi.models.Crop
import com.shanks.fasalsaathi.models.StorageItem
import com.shanks.fasalsaathi.models.indianCrops
//import com.shanks.fasalsaathi.models.storageItems
import com.shanks.fasalsaathi.ui.screens.crop.CropDetailScreen
import com.shanks.fasalsaathi.ui.screens.storageScreen.StorageDetailScreen
import com.shanks.fasalsaathi.ui.theme.FasalSaathiTheme
import com.shanks.fasalsaathi.ui.theme.Green1
import com.shanks.fasalsaathi.ui.theme.Green2
import com.shanks.fasalsaathi.ui.theme.Green3
import com.shanks.fasalsaathi.ui.theme.Green4
import com.shanks.fasalsaathi.ui.theme.PurpleGrey80

@Composable
fun PreviewScreens() {
    
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainSearchBar(
    textFieldState : MutableState<TextFieldValue>,
    placeHolder : String,
    modifier : Modifier
) {
    OutlinedCard(
        modifier
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            Color.White
        ),
        elevation = CardDefaults.cardElevation(
            10.dp
        ),
        border = BorderStroke(1.dp, color = Color.Black)
    ){
        TextField(
            value = textFieldState.value,
            onValueChange = { value ->
                textFieldState.value = value
            },
            modifier
                .fillMaxWidth()
                .padding(0.dp),
            label = {
                Text(text = placeHolder)
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Green2
            ),
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(
                color = Color.Black, fontSize = 20.sp
            ),
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search")
            }
        )
    }

}

@Composable
fun CropCard(crop : Crop) {
    val navigator = LocalNavigator.currentOrThrow
    Column(
        modifier = Modifier
            .padding(6.dp)
            .width(180.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = Modifier
                .clickable {
                    navigator.push(CropDetailScreen(crop))
                }
                .height(110.dp)

        ) {

            if(crop.crop_image != null || crop.crop_image != ""){
                SubcomposeAsyncImage(
                    model = crop.crop_image,
                    contentDescription = "cropImage",
                    contentScale = ContentScale.Crop,
                    loading = {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator(
                                color = Green1
                            )
                        }
                    }
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.crop_image),
                    contentDescription = ("crop_image" ),
                    contentScale = ContentScale.Fit,
                )
            }


        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = crop.name,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline
                )
            )

        )
    }
}

@Composable
fun StorageCard(storage : StorageItem) {

    val navigator = LocalNavigator.currentOrThrow

    OutlinedCard(
        modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .padding(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp, pressedElevation = 12.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {

        if (storage.storage_image == null || storage.storage_image == ""){
            Image(
                painter = painterResource(id = R.drawable.storage_image),
                contentDescription = "storagePhoto",
                alignment = Alignment.TopCenter,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(1.2.dp),
                contentScale = ContentScale.FillBounds,
            )
        } else {
            SubcomposeAsyncImage(
                model = storage.storage_image,
                contentDescription = "storage_image",
                alignment = Alignment.TopCenter,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(1.2.dp),
                contentScale = ContentScale.FillBounds
            )
        }



        Row(
            modifier =  Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = storage.name,
                modifier = Modifier.padding(start = 3.dp, top = 3.dp),
                maxLines = 1,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.SemiBold
            )
            StatusChipCard2(status = storage.available)
        }


        Text(text = "Location : ${storage.location}",
            modifier = Modifier.padding(start = 4.dp),
            maxLines = 1,
            fontSize = 12.sp,
            fontWeight = FontWeight.W500,
            style = TextStyle(
                letterSpacing = 1.sp
            )
        )

        Text(text = "Capacity : ${storage.capacity} Quintels",
            modifier = Modifier.padding(start = 4.dp, top = 2.dp),
            maxLines = 1,
            fontSize = 12.sp,
            fontWeight = FontWeight.W500,
            style = TextStyle(
                letterSpacing = 1.sp
            )
        )

        OutlinedCard(
            modifier = Modifier
                .clickable {
                    navigator.push(StorageDetailScreen(storage))
                }
                .padding(3.dp)
                .width(80.dp),
            colors = CardDefaults.cardColors(PurpleGrey80)

        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Details ->",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(2.dp)
                )
            }

        }

    }
}

@Composable
fun StatusChipCard(
    status : Boolean,
    horizontalPadding : Dp = 0.dp
) {
    var statusColor by remember {
        mutableStateOf(Color.White)
    }

    statusColor = if (status){
        Green1
    } else {
        Color.Red
    }

    Card(
        modifier = Modifier
            .padding(top = 3.dp, end = 4.dp, start = horizontalPadding)
            .height(25.dp)
            .width(60.dp)
            .padding(2.dp),
        colors = CardDefaults.cardColors(statusColor)
    ) {
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(status){
                Text(
                    text = "Available",
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.W600
                )
            } else {
                Text(
                    text = "NA",
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.W600
                )
            }
        }


    }
}

@Composable
fun StatusChipCard2(
    status : String,
    horizontalPadding : Dp = 0.dp
) {
    var statusColor by remember {
        mutableStateOf(Color.White)
    }

    statusColor = if (status == "0"){
        Green1
    } else {
        Color.Red
    }

    Card(
        modifier = Modifier
            .padding(top = 3.dp, end = 4.dp, start = horizontalPadding)
            .height(25.dp)
            .width(60.dp)
            .padding(2.dp),
        colors = CardDefaults.cardColors(statusColor)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(status == "0"){
                Text(
                    text = "Available",
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.W600
                )
            } else {
                Text(
                    text = "NA",
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.W600
                )
            }
        }


    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewScreensPrev() {
    FasalSaathiTheme {
//        StorageCard(storage = storageItems[0])
//        StatusChipCard(status = true)
    }
}