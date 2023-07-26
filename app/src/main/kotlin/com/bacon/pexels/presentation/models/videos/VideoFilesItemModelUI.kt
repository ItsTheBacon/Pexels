package com.bacon.pexels.presentation.models.videos

import android.os.Parcelable
import com.bacon.domain.models.videos.VideoFilesItemModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoFilesItemModelUI(
    val fileType: String = "",
    val width: Int = 0,
    val link: String = "",
    val id: Int = 0,
    val quality: String = "",
    val height: Int = 0
) : Parcelable

fun VideoFilesItemModel.toUI() = VideoFilesItemModelUI(fileType, width, link, id, quality, height)