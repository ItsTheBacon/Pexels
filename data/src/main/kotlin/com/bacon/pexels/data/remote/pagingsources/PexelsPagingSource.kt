package com.bacon.pexels.data.remote.pagingsources

import com.bacon.domain.models.photos.PexelPhotoModel
import com.bacon.pexels.data.base.BasePagingSource
import com.bacon.pexels.data.remote.apiservices.PexelsApiService
import com.bacon.pexels.data.remote.dtos.photos.PexelPhotoDto

class PexelsPagingSource(
    private val apiService: PexelsApiService,
    private val perPage: Int
) : BasePagingSource<PexelPhotoDto, PexelPhotoModel>({
    apiService.fetchCurated(it, perPage)
})