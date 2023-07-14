package com.bacon.pexels.presentation.ui.fragments.gallery.detail

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.pexels.R
import com.bacon.pexels.databinding.FragmentPhotoViewingBinding
import com.bacon.pexels.presentation.base.BaseFragment
import com.bacon.pexels.presentation.extensions.loadUrl
import com.bacon.pexels.presentation.ui.state.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoViewingFragment : BaseFragment<PhotoViewingViewModel, FragmentPhotoViewingBinding>(
    R.layout.fragment_photo_viewing
) {
    override val viewModel by viewModels<PhotoViewingViewModel>()
    override val binding by viewBinding(FragmentPhotoViewingBinding::bind)
    private val args by navArgs<PhotoViewingFragmentArgs>()

    override fun setupRequests() {
        viewModel.fetchPhotoById(args.id)
    }

    override fun setupSubscribers() = with(binding) {
        viewModel.fetchPhotoByIdState.collectUIState(
            onSuccess = {
                imageViewingPhoto.loadUrl(it.src.original, onLoad = { isVisible ->
                    loaderPhotoViewing.isVisible = isVisible
                })
            },
            onError = {
                it.setupApiErrors()
            },
            state = {
                loaderPhotoViewing.isVisible = it is UIState.Loading
                imageViewingPhoto.isVisible = it is UIState.Success
            }
        )
    }
}