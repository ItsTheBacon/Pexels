package com.bacon.pexels.presentation.ui.fragments.videos

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.pexels.R
import com.bacon.pexels.databinding.FragmentVideosBinding
import com.bacon.pexels.presentation.base.BaseFragment
import com.bacon.pexels.presentation.extensions.navigateSafely
import com.bacon.pexels.presentation.models.videos.PexelVideoModelUI
import com.bacon.pexels.presentation.ui.adapters.VideosAdapter
import com.bacon.pexels.presentation.ui.state.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideosFragment : BaseFragment<VideosViewModel, FragmentVideosBinding>(
    R.layout.fragment_videos
) {
    override val viewModel by viewModels<VideosViewModel>()
    override val binding by viewBinding(FragmentVideosBinding::bind)
    private val videosAdapter = VideosAdapter(this::setonVideoItemClickListener)


    override fun initialize() {
        binding.rvVideos.apply {
            adapter = videosAdapter
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        }
    }

    override fun setupRequests() {
        viewModel.fetchVideos()
    }

    override fun setupSubscribers() {
        viewModel.fetchVideosState.collectUIState(
            onError = {},
            onSuccess = {
                videosAdapter.submitList(it.videos)
            },
            state = {
                binding.loaderVideos.isVisible = it is UIState.Loading
            }
        )
    }

    private fun setonVideoItemClickListener(item: PexelVideoModelUI) {
        findNavController().navigateSafely(
            VideosFragmentDirections.actionVideosFragmentToVideoDetailFragment(item)
        )
    }
}