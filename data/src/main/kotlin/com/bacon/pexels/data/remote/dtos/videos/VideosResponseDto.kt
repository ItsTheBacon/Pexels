package com.bacon.pexels.data.remote.dtos.videos

import com.bacon.domain.models.videos.VideosResponseModel
import com.bacon.pexels.data.utils.DataMapper
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideosResponseDto(
    @Json(name = "page") val page: Int?,
    @Json(name = "per_page") val perPage: Int?,
    @Json(name = "total_results") val totalResults: Int?,
    @Json(name = "url") val url: String?,
    @Json(name = "videos") val videos: List<PexelVideosDto>?
) : DataMapper<VideosResponseModel> {
    override fun mapToDomain() =
        VideosResponseModel(page, perPage, totalResults, url, videos?.map { it.mapToDomain() })
}