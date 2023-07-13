package com.bacon.pexels.data.remote.client

import com.bacon.pexels.data.remote.apiservices.PexelsApiService
import com.bacon.pexels.data.remote.client.interceptors.AuthorizationInterceptor
import javax.inject.Inject

class NetworkClient @Inject constructor() {

    private val provideRetrofit = provideRetrofit(
        provideOkHttpClientBuilder().apply {
            addInterceptor(AuthorizationInterceptor())
        }.build()
    )

    fun providePexelsApiService(): PexelsApiService = provideRetrofit.create(
        PexelsApiService::class.java
    )

}