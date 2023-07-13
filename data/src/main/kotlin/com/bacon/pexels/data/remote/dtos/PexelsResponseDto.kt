package com.bacon.pexels.data.remote.dtos

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PexelsResponseDto<T>(
    @Json(name = "page") val page: Int?,
    @Json(name = "per_page") val perPage: Int?,
    @Json(name = "photos") val photos: List<T>,
    @Json(name = "next_page") val nextPage: String?
)