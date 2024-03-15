package com.shanks.fasalsaathi.ui.screens.chaupal

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import com.shanks.fasalsaathi.ui.screens.components.SayHiToScreen

class ChaupalScreen : Screen {
    @Composable
    @Preview(showSystemUi = true, showBackground = true)
    override fun Content() {
        SayHiToScreen(text = "Chaupal Screen")
    }
}

