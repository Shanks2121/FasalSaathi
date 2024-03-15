package com.shanks.fasalsaathi.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBusiness
import androidx.compose.material.icons.filled.Api
import androidx.compose.material.icons.filled.SmartScreen
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.shanks.fasalsaathi.R
import com.shanks.fasalsaathi.ui.screens.components.CropCard
import com.shanks.fasalsaathi.ui.screens.components.CustomTopBar
import com.shanks.fasalsaathi.ui.screens.components.CustomTopBar2
import com.shanks.fasalsaathi.ui.screens.components.CustomTopBar3
import com.shanks.fasalsaathi.ui.screens.components.SayHiToScreen
import com.shanks.fasalsaathi.ui.screens.crop.CropScreen
import com.shanks.fasalsaathi.ui.screens.storageScreen.StorageScreen
import com.shanks.fasalsaathi.ui.theme.FasalSaathiTheme
import com.shanks.fasalsaathi.ui.theme.Green1
import com.shanks.fasalsaathi.ui.theme.Green2
import com.shanks.fasalsaathi.ui.theme.Green3
import com.shanks.fasalsaathi.ui.theme.Green4
import com.shanks.fasalsaathi.ui.theme.Yellow1


class HomeScreen : Screen {
    @Composable
    @Preview(showSystemUi = true, showBackground = true)
    override fun Content() {
        ScreenHome()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHome() {

    val navigator = LocalNavigator.currentOrThrow
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState, true)
            .fillMaxWidth()
            .height(1000.dp)
            .padding(12.dp)
    ) {
        CustomTopBar3(title = "Home")
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            onClick = {  },
            colors = CardDefaults.cardColors(Green4)
        ) {
            Text(
                text = "Farmers WellFare Schemes",
                modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.W500
            )
        }
        CarousalCard()
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(onClick = {
                navigator.push(StorageScreen())
           }
            ) {
                Text(
                    text = "Explore Nearest Storage Houses",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Green3
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            onClick = {  },
            colors = CardDefaults.cardColors(Green4)
        ) {
            Text(
                text = "Get To Know Your Crops",
                modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.W500
            )
        }

        val cropImages = listOf(
            R.drawable.cucumber_lmofnm,
            R.drawable.groundnut_amhbud,
            R.drawable.soyabeans_bxbxwf,
            R.drawable.watermelon_ktnq0f
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(cropImages){
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(100.dp)
                        .height(100.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = it)
                        , contentDescription = "Crop_Image",
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
        Row(
            modifier =  Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(onClick = {  navigator.push(CropScreen())}) {
                Text(
                    text = "Know More ->",
                    color = Green3
                )
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                onClick = {  },
                colors = CardDefaults.cardColors(Green4)
            ) {
                Text(
                    text = "ABOUT US",
                    modifier = Modifier
                        .padding(5.dp)
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    fontWeight = FontWeight.W500
                )
            }
        }
        
        Row {
            AboutUsCard(icon = Icons.Filled.AddBusiness, title = "Storages", des = "Our Aim To Provide The Best Storages To Our Farmers")
            AboutUsCard(icon = Icons.Filled.Api, title = "Crop Details", des = "Know About Your Crops At A Single Place")
            AboutUsCard(icon = Icons.Filled.SmartScreen, title = "Schemes", des = "Get To Know About The Newest Farmers Welfare Schemes")
        }


    }

}

