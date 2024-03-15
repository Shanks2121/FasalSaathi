package com.shanks.fasalsaathi.ui.screens.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import com.shanks.fasalsaathi.Login
import com.shanks.fasalsaathi.ui.screens.profile.getVideoUri

class LoginScreen : Screen {
    @Composable
    override fun Content() {
        Login(videoUri = getVideoUri(LocalContext.current))
    }
}