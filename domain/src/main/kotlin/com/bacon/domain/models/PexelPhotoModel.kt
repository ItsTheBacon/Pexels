package com.bacon.domain.models

data class PexelPhotoModel(
    val id: Int,
    val width: Int,
    val height: Int,
    val url: String,
    val photographer: String,
    val photographerUrl: String,
    val photographer_id: Int,
    val avgColor: String,
    val src: SrcModel,
    val liked: Boolean,
    val alt: String
)
