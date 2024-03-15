package com.shanks.fasalsaathi.ui.screens.storageScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.shanks.fasalsaathi.ui.screens.components.CropCard
import com.shanks.fasalsaathi.ui.screens.components.CustomTopBar
import com.shanks.fasalsaathi.ui.screens.components.LoadingDialogTruck
import com.shanks.fasalsaathi.ui.screens.components.MainSearchBar
import com.shanks.fasalsaathi.ui.screens.components.SayHiToScreen
import com.shanks.fasalsaathi.ui.screens.components.StorageCard
import com.shanks.fasalsaathi.ui.viewmodels.StorageViewModel


class StorageScreen : Screen {
    @Composable
    @Preview(showSystemUi = true, showBackground = true)
    override fun Content() {
        val storageViewModel = getViewModel<StorageViewModel>()
        val textState = remember {
            mutableStateOf(TextFieldValue(""))
        }
        var storageList = storageViewModel.storageList.collectAsState()
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            CustomTopBar(title = "Storages")
            MainSearchBar(textFieldState = textState, placeHolder = "Search", modifier =Modifier)
            if (storageList.value.isNotEmpty()){
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2)
                ) {
                    items(storageList.value){
                        StorageCard(storage = it)
                    }
                }
            } else {
                LoadingDialogTruck()
            }
        }
    }
}

