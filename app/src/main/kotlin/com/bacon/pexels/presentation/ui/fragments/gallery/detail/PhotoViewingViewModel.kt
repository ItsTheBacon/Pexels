package com.bacon.pexels.presentation.ui.fragments.gallery.detail

import com.bacon.domain.usecases.FetchPhotoByIdUseCase
import com.bacon.pexels.presentation.base.BaseViewModel
import com.bacon.pexels.presentation.models.PexelPhotoModelUI
import com.bacon.pexels.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PhotoViewingViewModel @Inject constructor(
    private val fetchPhotoByIdUseCase: FetchPhotoByIdUseCase
) : BaseViewModel() {

    private val _fetchPhotoByIdState = MutableUIStateFlow<PexelPhotoModelUI>()
    val fetchPhotoByIdState = _fetchPhotoByIdState.asStateFlow()

    fun fetchPhotoById(id: Int) =
        fetchPhotoByIdUseCase(id).collectNetworkRequest(_fetchPhotoByIdState) { it.toUI() }
}