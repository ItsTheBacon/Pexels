package com.bacon.pexels.data.remote.dtos.videos

import com.bacon.domain.models.videos.PexelVideoModel
import com.bacon.pexels.data.utils.DataMapper
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PexelVideosDto(
    @Json(name = "duration")
    val duration: Int = 0,
    @Json(name = "image")
    val image: String = "",
    @Json(name = "width")
    val width: Int = 0,
    @Json(name = "video_files")
    val videoFiles: List<VideoFilesItemDto>?,
    @Json(name = "video_pictures")
    val videoPictures: List<VideoPicturesItemDto>?,
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "user")
    val user: UserDto,
    @Json(name = "url")
    val url: String = "",
    @Json(name = "height")
    val height: Int = 0
) : DataMapper<PexelVideoModel> {
    override fun mapToDomain() = PexelVideoModel(
        duration,
        image,
        width,
        videoFiles?.map { it.mapToDomain() },
        videoPictures?.map { it.mapToDomain() },
        id,
        user.mapToDomain(),
        url,
        height,
    )
}