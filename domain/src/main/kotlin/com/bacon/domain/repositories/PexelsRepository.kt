package com.bacon.domain.repositories

import com.bacon.domain.core.RemotePagingWrapper
import com.bacon.domain.core.RemoteWrapper
import com.bacon.domain.models.photos.PexelPhotoModel
import com.bacon.domain.models.videos.VideosResponseModel

interface PexelsRepository {

    fun fetchCurated(): RemotePagingWrapper<PexelPhotoModel>

    fun fetchPhotoById(id: Int): RemoteWrapper<PexelPhotoModel>

    fun fetchPopularVideos(): RemoteWrapper<VideosResponseModel>
}