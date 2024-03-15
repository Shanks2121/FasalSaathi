package com.shanks.fasalsaathi.ui.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.shanks.fasalsaathi.R
import com.shanks.fasalsaathi.ui.theme.FasalSaathiTheme
import kotlinx.coroutines.delay

@Composable
fun SayHiToScreen(text : String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hi $text",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
            )
    }
}

@Composable
fun CustomTopBar(
    title : String,
    icon : ImageVector? = null,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.W500,
                textDecoration = TextDecoration.Underline
            )

            if (icon != null) {
                Icon(imageVector = icon, contentDescription ="Profile Icon")
            }
        }

}

@Composable
fun CustomTopBar2(
    title : String,
    space : Dp = 125.dp,
    horizontalPadding : Dp = 0.dp
) {
    val navigator = LocalNavigator.currentOrThrow

    Row(
        modifier = Modifier
            .padding(horizontal = horizontalPadding)
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(space!!),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier.clickable {
                navigator.pop()
            },
            imageVector = Icons.Outlined.ArrowBackIosNew,
            contentDescription = "Back")

        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.W500,
        )

    }

}

@Composable
fun CustomTopBar3(
    title : String,
    space : Dp = 125.dp,
    horizontalPadding : Dp = 0.dp
) {

    Row(
        modifier = Modifier
            .padding(horizontal = horizontalPadding)
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {


        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.W600,
        )

    }

}

@Composable
fun CircularNextButton(
    modifier: Modifier = Modifier,
    onClick : () -> Unit,
    icon: ImageVector,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    elevation: Dp = 4.dp
) {
    Card(
        modifier = modifier
            .size(70.dp) // Adjust size as needed
            .padding(8.dp)
            .clickable { onClick() }
        ,
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(elevation),
        colors = CardDefaults.cardColors(backgroundColor)

    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                imageVector = icon,
                tint = Color.White,
                contentDescription = "Forward",

                )
        }
    }
}

@Composable
fun LottieScreen() {
    var isDialog by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(onClick = { isDialog = true }) {
            Text(text = "Show Dialog")
        }
    }

    if (isDialog){
        LoadingDialogTruck()
        LaunchedEffect(Unit){
            delay(5000)
            isDialog = false
        }


    }
}

@Composable
fun LottieSplashLogo() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.splash_animated))
    LottieAnimation(
        composition = composition,
    )
}

@Composable
fun LoadingDialogTruck() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.loading_truck))
    Dialog(onDismissRequest = {  }){
        Card(
            modifier = Modifier
                .width(120.dp)
                .height(120.dp)
                .padding(20.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
            )
        }
    }
}

@Preview
@Composable
fun ComponentsPreview() {
    FasalSaathiTheme {
        CustomTopBar2(title = "Details")
    }
}