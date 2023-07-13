package com.bacon.pexels.data.remote.client.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "PKkkJxeUe3oxFBMI3joZrR33xVFfkD1I94SOTFA5gGwMuRqPtWKSX2EZ")
            .build()
        return chain.proceed(request)
    }
}