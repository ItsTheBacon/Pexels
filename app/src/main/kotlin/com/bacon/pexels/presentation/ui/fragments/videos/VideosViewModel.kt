package com.bacon.pexels.presentation.ui.fragments.videos

import com.bacon.domain.usecases.FetchPopularVideosUseCase
import com.bacon.pexels.presentation.base.BaseViewModel
import com.bacon.pexels.presentation.models.videos.VideosResponseModelUI
import com.bacon.pexels.presentation.models.videos.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class VideosViewModel @Inject constructor(
    private val fetchPopularVideosUseCase: FetchPopularVideosUseCase
) : BaseViewModel() {

    private val _fetchVideosState = MutableUIStateFlow<VideosResponseModelUI>()
    val fetchVideosState = _fetchVideosState.asStateFlow()

    fun fetchVideos() {
        fetchPopularVideosUseCase().collectNetworkRequest(_fetchVideosState) {
            it.toUI()
        }
    }
}