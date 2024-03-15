package com.shanks.fasalsaathi.ui.screens.home

import androidx.lifecycle.ViewModel
import com.shanks.fasalsaathi.models.Crop
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Retrofit

//@HiltViewModel
//class HomeViewModel constructor(
//
//) : ViewModel() {
//
//    private val _crops = MutableStateFlow<List<Crop>>(emptyList())
//    val crops: StateFlow<List<Crop>> get() = _crops
//
//    suspend fun getCrops(){
//
//    }
//
//}