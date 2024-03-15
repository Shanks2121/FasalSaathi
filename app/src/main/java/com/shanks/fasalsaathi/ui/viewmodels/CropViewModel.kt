package com.shanks.fasalsaathi.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shanks.fasalsaathi.data.remote.api.CropsApi
import com.shanks.fasalsaathi.models.Crop
import com.shanks.fasalsaathi.models.indianCrops
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CropViewModel @Inject constructor(
    private val cropsApi : CropsApi
) : ViewModel() {

    private val _cropsList = MutableStateFlow<List<Crop>>(emptyList())
    val cropsList: StateFlow<List<Crop>> get() = _cropsList

    private suspend fun getCropsList(){
        val response = cropsApi.getCrops()
        if(response.isSuccessful && response.body() != null){
            _cropsList.emit(response.body()!!)
        }
    }

    init {
        viewModelScope.launch {
            getCropsList()
        }
    }

}