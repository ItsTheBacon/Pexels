package com.bacon.pexels.data.remote.dtos

import com.bacon.domain.models.PexelPhotoModel
import com.bacon.pexels.data.utils.DataMapper
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PexelPhotoDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "width")
    val width: Int,
    @Json(name = "height")
    val height: Int,
    @Json(name = "url")
    val url: String,
    @Json(name = "photographer")
    val photographer: String,
    @Json(name = "photographer_url")
    val photographerUrl: String,
    @Json(name = "photographer_id")
    val photographer_id: Int,
    @Json(name = "avg_color")
    val avgColor: String,
    @Json(name = "src")
    val src: SrcDto,
    @Json(name = "liked")
    val liked: Boolean,
    @Json(name = "alt")
    val alt: String
) : DataMapper<PexelPhotoModel> {
    override fun mapToDomain() = PexelPhotoModel(
        id,
        width,
        height,
        url,
        photographer,
        photographerUrl,
        photographer_id,
        avgColor,
        src.mapToDomain(),
        liked,
        alt
    )
}
