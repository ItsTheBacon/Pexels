package com.bacon.pexels.presentation.models.videos

import com.bacon.domain.models.videos.VideoPicturesItemModel

data class VideoPicturesItemModelUI(
    val nr: Int = 0,
    val id: Int = 0,
    val picture: String = ""
)

fun VideoPicturesItemModel.toUI() = VideoPicturesItemModelUI(nr, id, picture)