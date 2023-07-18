package com.bacon.pexels.data.remote.dtos.videos

import com.bacon.domain.models.videos.UserModel
import com.bacon.pexels.data.utils.DataMapper
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDto(
    @Json(name = "name")
    val name: String = "",
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "url")
    val url: String = ""
) : DataMapper<UserModel> {
    override fun mapToDomain() = UserModel(name, id, url)
}