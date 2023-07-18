package com.bacon.pexels.presentation.ui.fragments.videos

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.pexels.R
import com.bacon.pexels.databinding.FragmentVideosBinding
import com.bacon.pexels.presentation.base.BaseFragment
import com.bacon.pexels.presentation.ui.adapters.VideosAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideosFragment : BaseFragment<VideosViewModel, FragmentVideosBinding>(
    R.layout.fragment_videos
) {
    override val viewModel by viewModels<VideosViewModel>()
    override val binding by viewBinding(FragmentVideosBinding::bind)
    private val videosAdapter = VideosAdapter()


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
            }
        )
    }
}