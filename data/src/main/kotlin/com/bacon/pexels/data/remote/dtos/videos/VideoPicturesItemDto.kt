package com.bacon.pexels.data.remote.dtos.videos

import com.bacon.domain.models.videos.VideoPicturesItemModel
import com.bacon.pexels.data.utils.DataMapper
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideoPicturesItemDto(
    @Json(name = "nr")
    val nr: Int = 0,
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "picture")
    val picture: String = ""
) : DataMapper<VideoPicturesItemModel> {
    override fun mapToDomain() = VideoPicturesItemModel(nr, id, picture)
}