package com.bacon.pexels.presentation.models

import com.bacon.domain.models.photos.SrcModel

data class SrcModelUI(
    val original: String,
    val large2x: String,
    val large: String,
    val medium: String,
    val small: String,
    val portrait: String,
    val landscape: String,
    val tiny: String
)

fun SrcModel.toUI() = SrcModelUI(original, large2x, large, medium, small, portrait, landscape, tiny)