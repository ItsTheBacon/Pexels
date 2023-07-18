package com.bacon.pexels.presentation.models

import com.bacon.domain.models.photos.PexelPhotoModel
import com.bacon.pexels.presentation.base.IBaseDiffModel

data class PexelPhotoModelUI(
    override val id: Int,
    val width: Int,
    val height: Int,
    val url: String,
    val photographer: String,
    val photographerUrl: String,
    val photographer_id: Int,
    val avgColor: String,
    val src: SrcModelUI,
    val liked: Boolean,
    val alt: String
) : IBaseDiffModel<Int>

fun PexelPhotoModel.toUI() = PexelPhotoModelUI(
    id,
    width,
    height,
    url,
    photographer,
    photographerUrl,
    photographer_id,
    avgColor,
    src.toUI(),
    liked,
    alt
)