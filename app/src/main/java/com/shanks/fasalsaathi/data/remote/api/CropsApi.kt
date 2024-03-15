package com.shanks.fasalsaathi.data.remote.api

import com.shanks.fasalsaathi.models.Crop
import com.shanks.fasalsaathi.models.StorageItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface CropsApi {

    @GET("crops")
    suspend fun getCrops() : Response<List<Crop>>

    @GET("crops/{crop_name}")
    suspend fun getCropData(@Path("crop_name") crop : String) : Response<Crop>

}