package com.shanks.fasalsaathi.ui.screens.crop

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CurrencyRupee
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.shanks.fasalsaathi.models.Crop
import com.shanks.fasalsaathi.models.Storage
import com.shanks.fasalsaathi.models.StorageItem
import com.shanks.fasalsaathi.models.indianCrops
import com.shanks.fasalsaathi.ui.screens.components.CustomTopBar2
import com.shanks.fasalsaathi.ui.screens.components.SayHiToScreen
import com.shanks.fasalsaathi.ui.screens.components.StatusChipCard
import com.shanks.fasalsaathi.ui.screens.components.TopImage
import com.shanks.fasalsaathi.ui.theme.Green1

data class CropDetailScreen(val crop : Crop = indianCrops[0]) : Screen {
    @Composable
    override fun Content() {
        DetailsCropScreen(crop)
    }
}

@Composable
fun DetailsCropScreen(crop : Crop) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
    ) {

        val scroll = rememberScrollState()

        CustomTopBar2(
            title = "Details",
            space = 110.dp,
            horizontalPadding = 10.dp
        )
        TopImage(crop.crop_image)
        Text(
            text = crop.name,
            modifier = Modifier.padding(horizontal = 21.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.W800,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(8.dp))
       Column(
           modifier = Modifier
               .padding(horizontal = 22.dp)
               .height(300.dp)
               .verticalScroll(
                   state = scroll,
                   enabled = true
               )
       ) {
           Text(
               text = "Season -:",
               style = MaterialTheme.typography.titleLarge,
               fontWeight = FontWeight.W600
               )
           Spacer(modifier = Modifier.height(8.dp))

           BorderedBox(title = crop.season, horizontalPadding = 20.dp)

           Spacer(modifier = Modifier.height(8.dp))
           Text(
               text = "Crop Type -:",
               style = MaterialTheme.typography.titleLarge,
               fontWeight = FontWeight.W600
           )
           Spacer(modifier = Modifier.height(8.dp))
           BorderedBox(title = crop.type, horizontalPadding = 20.dp)
           Spacer(modifier = Modifier.height(8.dp))
           Text(text = "Soil Type -:",
               style = MaterialTheme.typography.titleLarge,
               fontWeight = FontWeight.W600
           )
           Spacer(modifier = Modifier.height(8.dp))
           Box(
               modifier = Modifier
                   .clip(RoundedCornerShape(6.dp))
                   .border(width = 2.dp, color = Color.Black)
           ){
               Text(
                   text = crop.soil,
                   style = MaterialTheme.typography.bodyLarge,
                   modifier = Modifier.padding(3.dp)
               )
           }
           Spacer(modifier = Modifier.height(8.dp))
           Text(text = "Month Of Harvest -:",
               style = MaterialTheme.typography.titleLarge,
               fontWeight = FontWeight.W600
           )
           Spacer(modifier = Modifier.height(8.dp))
           Box(
               modifier = Modifier
                   .clip(RoundedCornerShape(6.dp))
                   .border(width = 2.dp, color = Color.Black)
           ){
               Text(
                   text = crop.month_of_harvest,
                   style = MaterialTheme.typography.bodyLarge,
                   modifier = Modifier.padding(3.dp)
               )
           }
       }

//

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BorderedBox(
    title : String = "Season",
    horizontalPadding : Dp = 0.dp){
//    OutlinedCard(
//        onClick = { /*TODO*/ },
//        modifier = Modifier.padding(horizontal = horizontalPadding),
//        shape = RoundedCornerShape(5.dp),
//        border = BorderStroke(width = 2.dp, color = Green1)
//    ) {
//        Text(
//            text = "$title",
//            modifier = Modifier.padding(2.dp)
//        )
//    }
    Box(
        modifier = Modifier
            .border(width = 2.dp , color = Green1)
    ) {
        Text(
            text = "$title",
            modifier = Modifier.padding(2.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Composable
fun StorageStatusComponent(storage: StorageItem, hp : Dp = 0.dp) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = hp)
        ,
        verticalAlignment = Alignment.CenterVertically,
    ){
        StatusChipCard(status = true, horizontalPadding = 22.dp)
        Spacer(modifier = Modifier.width(120.dp))
        PriceComponent(price = "${storage.price}")
    }
}

@Composable
fun PriceComponent(price : String) {

    Box(modifier = Modifier.border(2.dp ,Color.Gray )){
        Row(
            modifier = Modifier.padding(4.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.CurrencyRupee,
                modifier = Modifier
                    .size(30.dp)
                    .padding(top = 2.dp),
                contentDescription = "Rupee")
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(text = "$price/",
                    fontSize = 20.sp
                )
                Text(
                    text = "SqFeet",
                    modifier = Modifier.padding(bottom = 2.dp),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
        }




}