package com.bacon.domain.models.videos

data class VideosResponseModel(
    val page: Int?,
    val perPage: Int?,
    val totalResults: Int?,
    val url: String?,
    val videos: List<PexelVideoModel>?
)