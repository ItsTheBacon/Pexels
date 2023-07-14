package com.bacon.pexels.presentation.ui.fragments.gallery

import androidx.lifecycle.MutableLiveData
import com.bacon.domain.usecases.FetchCuratedPhotosUseCase
import com.bacon.pexels.presentation.base.BaseViewModel
import com.bacon.pexels.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    fetchCuratedPhotosUseCase: FetchCuratedPhotosUseCase
) : BaseViewModel() {

    val isRefreshing = MutableLiveData<Boolean>()

    val curatedPaging = fetchCuratedPhotosUseCase().collectPagingRequest { it.toUI() }
}