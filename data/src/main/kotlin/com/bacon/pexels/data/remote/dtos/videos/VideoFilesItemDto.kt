package com.bacon.pexels.data.remote.dtos.videos

import com.bacon.domain.models.videos.VideoFilesItemModel
import com.bacon.pexels.data.utils.DataMapper
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideoFilesItemDto(
    @Json(name = "file_type")
    val fileType: String = "",
    @Json(name = "width")
    val width: Int = 0,
    @Json(name = "link")
    val link: String = "",
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "quality")
    val quality: String = "",
    @Json(name = "height")
    val height: Int = 0
) : DataMapper<VideoFilesItemModel> {
    override fun mapToDomain() = VideoFilesItemModel(fileType, width, link, id, quality, height)
}