package com.shanks.fasalsaathi.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.shanks.fasalsaathi.ui.screens.tabs.ChaupalTab
import com.shanks.fasalsaathi.ui.screens.tabs.CropTab
import com.shanks.fasalsaathi.ui.screens.tabs.HomeTab
import com.shanks.fasalsaathi.ui.screens.tabs.StorageTab
import com.shanks.fasalsaathi.ui.theme.Green1
import com.shanks.fasalsaathi.ui.theme.Green2
import com.shanks.fasalsaathi.ui.theme.Green3

class MainScreen : Screen {
//    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    @Preview
    override fun Content() {
        TabNavigator(HomeTab) {
            Scaffold(
                content = {
                    Box(modifier = Modifier.padding(it)){
                        CurrentTab()
                    }
                },
                topBar = {

                },
                bottomBar = {
                    NavigationBar(
                        modifier = Modifier.clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)),
                        tonalElevation = NavigationBarDefaults.Elevation.plus(10.dp),
                        containerColor = Green3,
                        contentColor = Color.White
                    ) {
                        TabNavigationItem(tab = HomeTab)
                        TabNavigationItem(tab = CropTab)
                        TabNavigationItem(tab = StorageTab)
//                        TabNavigationItem(tab = ChaupalTab)
                    }
                }
            )
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current


    NavigationBarItem(
        modifier = Modifier,
        selected = tabNavigator.current == tab,
        alwaysShowLabel = false,
        colors = NavigationBarItemDefaults.colors(Green1),
        onClick = { tabNavigator.current = tab },
        icon = { tab.options.icon?.let { Icon(painter = it, contentDescription = tab.options.title, tint = Color.White) } },
        label = {
            Text(
                text = tab.options.title,
                color = Color.White
            )
        },
        
    )
}