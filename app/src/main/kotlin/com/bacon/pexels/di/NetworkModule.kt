package com.bacon.pexels.di

import com.bacon.pexels.data.remote.client.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providePexelsApiService(
        networkClient: NetworkClient
    ) = networkClient.providePexelsApiService()

}