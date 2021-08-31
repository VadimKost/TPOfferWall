package com.v.tpofferwall.di.modules

import com.v.tpofferwall.data.ResponseStateFactory
import com.v.tpofferwall.data.api.OfferWallApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://demo3005513.mockable.io/api/v1/")
            .addCallAdapterFactory(ResponseStateFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit): OfferWallApi =retrofit.create(OfferWallApi::class.java)
}