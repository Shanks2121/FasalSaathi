package com.shanks.fasalsaathi.ui.screens.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddBusiness
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.ScaleTransition
import com.shanks.fasalsaathi.ui.screens.chaupal.ChaupalScreen

object ChaupalTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Chaupal"
            val icon = rememberVectorPainter(image = Icons.Rounded.AddBusiness)

            return remember {

                TabOptions(
                    title = title,
                    index = 3u,
                    icon = icon
                )

            }
        }

    @Composable
    override fun Content() {
        Navigator(ChaupalScreen()){
                navigator ->  ScaleTransition(navigator = navigator)
        }
    }
}