package com.bacon.pexels.data.remote.dtos.photos

import com.bacon.domain.models.photos.SrcModel
import com.bacon.pexels.data.utils.DataMapper
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SrcDto(
    @Json(name = "original")
    val original: String,
    @Json(name = "large2x")
    val large2x: String,
    @Json(name = "large")
    val large: String,
    @Json(name = "medium")
    val medium: String,
    @Json(name = "small")
    val small: String,
    @Json(name = "portrait")
    val portrait: String,
    @Json(name = "landscape")
    val landscape: String,
    @Json(name = "tiny")
    val tiny: String
) : DataMapper<SrcModel> {
    override fun mapToDomain() =
        SrcModel(original, large2x, large, medium, small, portrait, landscape, tiny)
}