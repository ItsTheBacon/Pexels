package com.bacon.pexels.data.repositories

import com.bacon.domain.repositories.PexelsRepository
import com.bacon.pexels.data.base.BaseRepository
import com.bacon.pexels.data.remote.apiservices.PexelsApiService
import com.bacon.pexels.data.remote.pagingsources.PexelsPagingSource
import javax.inject.Inject

class PexelsRepositoryImpl @Inject constructor(
    private val service: PexelsApiService
) : BaseRepository(), PexelsRepository {

    override fun fetchCurated() = doPagingRequest({ PexelsPagingSource(service, 20) })

    override fun fetchPhotoById(id: Int) = doNetworkRequestWithMapping {
        service.fetchPhotoById(id)
    }

    override fun fetchPopularVideos() = doNetworkRequestWithMapping {
        service.fetchPopularVideos(20)
    }

}