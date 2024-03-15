package com.shanks.fasalsaathi.ui.screens.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.shanks.fasalsaathi.R
import com.shanks.fasalsaathi.ui.screens.MainScreen
import com.shanks.fasalsaathi.ui.screens.components.CircularNextButton
import com.shanks.fasalsaathi.ui.screens.login.LoginScreen
import com.shanks.fasalsaathi.ui.theme.Green1
import kotlinx.coroutines.delay


class SplashScreen : Screen {
    @Composable
    @Preview(showSystemUi = true, showBackground = true)
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.splash_animation_2))
        val animationSpec = tween<Float>(
            durationMillis = 6000,
            delayMillis = 800,
            easing = FastOutSlowInEasing
        )

        var showText by remember { mutableStateOf(false) }
        var forwardButton by remember {
            mutableStateOf(false)
        }

        LaunchedEffect(key1 = true) { // Key to avoid infinite loops
            showText = true // Initially set to false
            delay(7000) // Delay for 3 seconds
            forwardButton = true

        }

        Box(
            modifier = Modifier
                .fillMaxSize(),
//            .background(Color(red = 196, green = 231, blue = 156, alpha = 255)),
            contentAlignment = Alignment.Center
        ){

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {

                LottieAnimation(
                    composition = composition,
//                iterations = LottieConstants.IterateForever,
                    modifier = Modifier
                        .size(300.dp)
                )

                AnimatedVisibility(
                    visible = showText,
                    enter = fadeIn(animationSpec = animationSpec),
                    exit = fadeOut(animationSpec = animationSpec)
                ) {
                    Image(
                        modifier = Modifier
                            .height(100.dp)
                            .width(250.dp),
                        painter = painterResource(id = R.drawable.splash_logo),
                        contentDescription = "Fasal Saathi"
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                AnimatedVisibility(
                    visible = forwardButton,
                    enter = fadeIn(animationSpec = animationSpec),
                    exit = fadeOut(animationSpec = animationSpec)
                ) {
                    CircularNextButton(
                        onClick = {
                                  navigator.push(LoginScreen())
                        },
                        icon = Icons.Filled.ArrowForward,
                        backgroundColor = Green1)
                }
            }



        }
    }


}

