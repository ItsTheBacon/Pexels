package com.bacon.pexels.data.remote.apiservices

import com.bacon.pexels.data.remote.dtos.PexelPhotoDto
import com.bacon.pexels.data.remote.dtos.PexelsResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PexelsApiService {

    @GET("v1/curated")
    suspend fun fetchCurated(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): Response<PexelsResponseDto<PexelPhotoDto>>

    @GET("v1/photos/{id}")
    suspend fun fetchPhotoById(
        @Path("id") id: Int
    ): Response<PexelPhotoDto>
}