package com.bacon.pexels.presentation.ui.fragments.gallery

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.pexels.R
import com.bacon.pexels.databinding.FragmentGalleryBinding
import com.bacon.pexels.presentation.base.BaseFragment
import com.bacon.pexels.presentation.extensions.navigateSafely
import com.bacon.pexels.presentation.extensions.showToastLong
import com.bacon.pexels.presentation.ui.adapters.CuratedPhotoPagingAdapter
import com.bacon.pexels.presentation.ui.adapters.paging.CommonLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.io.InterruptedIOException

@AndroidEntryPoint
class GalleryFragment : BaseFragment<GalleryViewModel, FragmentGalleryBinding>(
    R.layout.fragment_gallery
) {
    override val viewModel by viewModels<GalleryViewModel>()
    override val binding by viewBinding(FragmentGalleryBinding::bind)

    private val curatedPagingAdapter =
        CuratedPhotoPagingAdapter(this::setOnCuratedItemClickListener)

    override fun initialize() {
        setupPagingRecycler()
    }

    private fun setupPagingRecycler() = with(binding) {
        with(rvCuratedPhotos) {
            val gridLayoutManager = GridLayoutManager(context, 2)
            layoutManager = gridLayoutManager
            val footerAdapter = CommonLoadStateAdapter { curatedPagingAdapter.retry() }
            itemAnimator = null
            adapter = curatedPagingAdapter.withLoadStateFooter(
                footer = footerAdapter
            )
            gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (position == curatedPagingAdapter.itemCount && footerAdapter.itemCount > 0) {
                        2
                    } else {
                        1
                    }
                }
            }
        }

        curatedPagingAdapter.addLoadStateListener { loadStates ->
            rvCuratedPhotos.isVisible = loadStates.refresh is LoadState.NotLoading
            loaderCuratedPaging.isVisible = loadStates.refresh is LoadState.Loading
            viewModel.isRefreshing.value = loadStates.refresh is LoadState.Loading

            if (loadStates.refresh is LoadState.Error) {
                if ((loadStates.refresh as LoadState.Error).error is InterruptedIOException) {
                    showToastLong("Timeout")
                }
            }
        }
    }

    override fun setupListeners() {
        setupSwipeRefresh()
    }

    private fun setupSwipeRefresh() = with(binding.curatedSwipe) {
        setColorSchemeResources(R.color.black)
        setOnRefreshListener {
            curatedPagingAdapter.refresh()
        }
        viewModel.isRefreshing.observe(viewLifecycleOwner) {
            isRefreshing = it
        }
    }

    override fun setupSubscribers() {
        viewModel.curatedPaging.collectPaging {
            curatedPagingAdapter.submitData(it)
        }
    }

    private fun setOnCuratedItemClickListener(id: Int) {
        findNavController().navigateSafely(
            GalleryFragmentDirections.actionGalleryFragmentToPhotoViewingFragment(
                id
            )
        )
    }
}