package com.bacon.domain.models.photos

data class PexelsResponseModel<T>(
    val page: Int?,
    val perPage: Int?,
    val photos: List<T>,
    val nextPage: String?,
    val totalResults: Int?,
    val url: String?,
    val videos: List<T>?
)