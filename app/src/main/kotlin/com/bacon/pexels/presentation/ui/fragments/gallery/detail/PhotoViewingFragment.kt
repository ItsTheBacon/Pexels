package com.bacon.pexels.presentation.ui.fragments.gallery.detail

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.pexels.R
import com.bacon.pexels.databinding.FragmentPhotoViewingBinding
import com.bacon.pexels.presentation.base.BaseFragment
import com.bacon.pexels.presentation.extensions.loadUrl
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

    override fun setupSubscribers() {
        viewModel.fetchPhotoByIdState.collectUIState(
            onSuccess = {
                Log.e("anime", "Pexels detail $it")
                binding.imageViewingPhoto.loadUrl(it.src.original)
            },
            onError = {
                it.setupApiErrors()
            }
        )
    }
}