package com.bacon.domain.usecases

import com.bacon.domain.repositories.PexelsRepository
import javax.inject.Inject

class FetchPhotoByIdUseCase @Inject constructor(
    private val repository: PexelsRepository
) {
    operator fun invoke(id: Int) = repository.fetchPhotoById(id)
}