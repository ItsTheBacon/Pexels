package com.bacon.pexels.presentation.models.videos

import android.os.Parcelable
import com.bacon.domain.models.videos.VideoPicturesItemModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoPicturesItemModelUI(
    val nr: Int = 0,
    val id: Int = 0,
    val picture: String = ""
):Parcelable

fun VideoPicturesItemModel.toUI() = VideoPicturesItemModelUI(nr, id, picture)