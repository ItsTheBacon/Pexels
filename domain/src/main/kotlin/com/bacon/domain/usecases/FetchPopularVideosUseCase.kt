package com.bacon.domain.usecases

import com.bacon.domain.repositories.PexelsRepository
import javax.inject.Inject

class FetchPopularVideosUseCase @Inject constructor(
    private val repository: PexelsRepository
) {
    operator fun invoke() = repository.fetchPopularVideos()
}