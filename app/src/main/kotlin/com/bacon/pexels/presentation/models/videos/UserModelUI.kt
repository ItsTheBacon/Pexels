package com.bacon.pexels.presentation.models.videos

import android.os.Parcelable
import com.bacon.domain.models.videos.UserModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModelUI(
    val name: String = "",
    val id: Int = 0,
    val url: String = ""
):Parcelable

fun UserModel.toUI() = UserModelUI(name, id, url)