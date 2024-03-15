package com.shanks.fasalsaathi.ui.screens.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Agriculture
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.FadeTransition
import cafe.adriel.voyager.transitions.ScaleTransition
import cafe.adriel.voyager.transitions.SlideTransition
import com.shanks.fasalsaathi.ui.screens.crop.CropScreen

object CropTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Crops"
            val icon = rememberVectorPainter(image = Icons.Rounded.Agriculture)

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(CropScreen()){
                navigator ->  SlideTransition(navigator = navigator)
        }
    }
}