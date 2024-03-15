package com.shanks.fasalsaathi.ui.screens.storageScreen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import cafe.adriel.voyager.core.screen.Screen
import com.shanks.fasalsaathi.models.StorageItem
import com.shanks.fasalsaathi.ui.screens.components.CustomTopBar2
import com.shanks.fasalsaathi.ui.screens.components.SayHiToScreen
import com.shanks.fasalsaathi.ui.screens.components.TopImage
import com.shanks.fasalsaathi.ui.screens.crop.BorderedBox
import com.shanks.fasalsaathi.ui.screens.crop.StorageStatusComponent
import com.shanks.fasalsaathi.ui.theme.Green1
import com.shanks.fasalsaathi.ui.theme.Green2
import com.shanks.fasalsaathi.ui.theme.Green3
import com.shanks.fasalsaathi.ui.theme.Green4

data class StorageDetailScreen(val storage : StorageItem) : Screen{
    @Composable
    override fun Content() {
        val context = LocalContext.current
        DetailStorageScreen(storage, context)
    }
}

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DetailStorageScreen(storage: StorageItem, context : Context) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top){
            CustomTopBar2(
                title = "Details",
                space = 105.dp,
                horizontalPadding = 10.dp
            )
        TopImage(storage.storage_image)
        Text(
            text = storage.name,
            modifier = Modifier.padding(horizontal = 22.dp),
            style = MaterialTheme.typography.titleLarge,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = storage.location,
            modifier = Modifier.padding(horizontal = 26.dp),
            style = MaterialTheme.typography.labelLarge
        )
        StorageStatusComponent(storage = storage)
        Column(
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .padding(top = 8.dp, start = 23.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Storage Type",
                style = MaterialTheme.typography.titleLarge,
                textDecoration = TextDecoration.Underline
            )
            Spacer(modifier = Modifier.height(10.dp))
            BorderedBox(storage.storage_type)
            Spacer(modifier = Modifier.height(3.dp))
            Row {
                Text(
                    text = "Capacity",
                    style = MaterialTheme.typography.titleLarge,
                    textDecoration = TextDecoration.Underline
                )
                Text(
                    text = "   ->   ${storage.capacity} quintels",
                    style = MaterialTheme.typography.titleLarge,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp, end = 30.dp)
                    .clip(RectangleShape)
                    .border(width = 2.dp, color = Color.Gray)
                    .padding(5.dp)
                    .fillMaxSize()
            ){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Available From -> ${storage?.available_from}",
                        fontWeight = FontWeight.W600
                    )
                    Text(text = "Availability Duration -> ${storage?.availability_duration} days", fontWeight = FontWeight.W600)
                }
            }


        }
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedCard(
                modifier = Modifier
                    .height(60.dp)
                    .clickable {
                       val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:${storage.contact}")
                        startActivity(context, intent, null)
                    }
                ,
                elevation = CardDefaults.cardElevation(8.dp),
                border = BorderStroke(2.dp, color = Green2),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "CONTACT",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Black,
                        fontStyle = FontStyle.Normal
                    )
                }

            }
        }


    }
}
