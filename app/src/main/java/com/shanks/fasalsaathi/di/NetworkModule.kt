package com.shanks.fasalsaathi.di

import android.content.Context
import com.shanks.fasalsaathi.data.remote.api.CropsApi
import com.shanks.fasalsaathi.data.remote.api.StorageApi
import com.shanks.fasalsaathi.utils.TokenManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

//    @Singleton
//    @Provides
//    fun provideMoshi(): Moshi {
//        return Moshi.Builder()
//            .build()
//    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
//            .also {
//                /**
//                 * Only add [HttpLoggingInterceptor] on debug build
//                 */
//                if (BuildConfig.DEBUG) {
//                    it.addInterceptor(getLoggingInterceptor())
//                }
//            }
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.234.242:8000/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()) // Register Moshi as a JSON converter for serialization and deserialization of objects.
            //            .addCallAdapterFactory(FlowerCallAdapterFactory.create()) // Register Flower as a response converter for supporting method return types other than Call<T>.
            .build()
    }

    @Singleton
    @Provides
    fun providesCropsApi(
        retrofit: Retrofit
    ) : CropsApi{
        return retrofit.create(CropsApi::class.java)
    }

    @Singleton
    @Provides
    fun providesStorageApi(
        retrofit: Retrofit
    ): StorageApi {
        return retrofit.create(StorageApi::class.java)
    }

    @Singleton
    @Provides
    fun provideTokenManager(@ApplicationContext context: Context): TokenManager {
        return TokenManager(context)
    }

}