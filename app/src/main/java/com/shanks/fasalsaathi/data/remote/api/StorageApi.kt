package com.shanks.fasalsaathi.data.remote.api

import com.shanks.fasalsaathi.models.StorageItem
import retrofit2.Response
import retrofit2.http.GET

interface StorageApi {

    @GET("storage")
    suspend fun getAllStorages() : Response<List<StorageItem>>

}