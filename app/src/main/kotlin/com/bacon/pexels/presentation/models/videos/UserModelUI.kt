package com.bacon.pexels.presentation.models.videos

import com.bacon.domain.models.videos.UserModel

data class UserModelUI(
    val name: String = "",
    val id: Int = 0,
    val url: String = ""
)

fun UserModel.toUI() = UserModelUI(name, id, url)