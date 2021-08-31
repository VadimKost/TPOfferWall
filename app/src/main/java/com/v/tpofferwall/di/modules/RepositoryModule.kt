package com.v.tpofferwall.di.modules

import com.v.tpofferwall.data.api.OfferWallApi
import com.v.tpofferwall.data.repositoty.DataRepositoryImpl
import com.v.tpofferwall.domain.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideDataRepository(impl: DataRepositoryImpl): DataRepository = impl
}