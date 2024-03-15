package com.shanks.fasalsaathi.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shanks.fasalsaathi.data.remote.api.StorageApi
import com.shanks.fasalsaathi.models.StorageItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StorageViewModel @Inject constructor(
    private val storage : StorageApi
) : ViewModel() {

    private val _storageList = MutableStateFlow<List<StorageItem>>(emptyList())
    val storageList: StateFlow<List<StorageItem>> get() = _storageList

    private suspend fun getStorageList(){
        val response = storage.getAllStorages()
        if (response.isSuccessful && response.body() !=null){
            _storageList.emit(response.body()!!)
        }
    }

    init {
        viewModelScope.launch {
            getStorageList()
        }
    }

}