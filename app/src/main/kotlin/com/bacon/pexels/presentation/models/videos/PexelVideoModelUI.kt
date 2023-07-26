package com.bacon.pexels.presentation.models.videos

import android.os.Parcelable
import com.bacon.domain.models.videos.PexelVideoModel
import com.bacon.pexels.presentation.base.IBaseDiffModel
import kotlinx.parcelize.Parcelize


@Parcelize
data class PexelVideoModelUI(
    val duration: Int = 0,
    val image: String = "",
    val width: Int? = 0,
    val videoFiles: List<VideoFilesItemModelUI>?,
    val videoPictures: List<VideoPicturesItemModelUI>?,
    override val id: Int = 0,
    val user: UserModelUI,
    val url: String = "",
    val height: Int? = 0
) : IBaseDiffModel<Int>, Parcelable

fun PexelVideoModel.toUI() = PexelVideoModelUI(
    duration,
    image,
    width,
    videoFiles?.map { it.toUI() },
    videoPictures?.map { it.toUI() },
    id,
    user.toUI(),
    url, height
)