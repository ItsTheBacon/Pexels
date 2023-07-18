package com.bacon.pexels.presentation.models.videos

import com.bacon.domain.models.videos.VideosResponseModel

data class VideosResponseModelUI(
    val page: Int?,
    val perPage: Int?,
    val totalResults: Int?,
    val url: String?,
    val videos: List<PexelVideoModelUI>?
)

fun VideosResponseModel.toUI() =
    VideosResponseModelUI(page, perPage, totalResults, url, videos?.map { it.toUI() })