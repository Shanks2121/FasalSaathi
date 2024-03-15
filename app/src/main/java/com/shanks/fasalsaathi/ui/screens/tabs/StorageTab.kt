package com.shanks.fasalsaathi.ui.screens.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cabin
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.ScaleTransition
import cafe.adriel.voyager.transitions.SlideTransition
import com.shanks.fasalsaathi.ui.screens.storageScreen.StorageScreen

object StorageTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Storage"
            val icon = rememberVectorPainter(image = Icons.Rounded.Cabin)

            return remember {
                TabOptions(
                    index = 3u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(StorageScreen()){
                navigator ->  SlideTransition(navigator = navigator)
        }
    }
}