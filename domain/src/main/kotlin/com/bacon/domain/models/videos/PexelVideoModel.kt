package com.bacon.domain.models.videos

data class PexelVideoModel(
    val duration: Int = 0,
    val image: String = "",
    val width: Int = 0,
    val videoFiles: List<VideoFilesItemModel>?,
    val videoPictures: List<VideoPicturesItemModel>?,
    val id: Int = 0,
    val user: UserModel,
    val url: String = "",
    val height: Int = 0
)