package com.bacon.pexels.presentation.ui.fragments.videos.detail

import android.annotation.SuppressLint
import android.net.Uri
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.pexels.R
import com.bacon.pexels.databinding.FragmentVideoDetailBinding
import com.bacon.pexels.presentation.base.BaseFragment
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class VideoDetailFragment : BaseFragment<VideoDetailViewModel, FragmentVideoDetailBinding>(
    R.layout.fragment_video_detail
) {
    override val viewModel by viewModels<VideoDetailViewModel>()
    override val binding by viewBinding(FragmentVideoDetailBinding::bind)
    private val args by navArgs<VideoDetailFragmentArgs>()
    private var player: SimpleExoPlayer? = null
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L

    override fun initialize() {
        initializePlayer()
    }

    private fun initializePlayer() {
        val link  = args.videoInfo.videoFiles?.get(0)?.link
        player = SimpleExoPlayer.Builder(requireContext())
            .build()
            .also { exoPlayer ->
                binding.player.player = exoPlayer
                val mediaItem =
                    MediaItem.fromUri(Uri.parse(link))
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(currentWindow, playbackPosition)
                exoPlayer.prepare()
            }
    }


    private fun releasePlayer() {
        player?.run {
            playbackPosition = this.currentPosition
            currentWindow = this.currentWindowIndex
            playWhenReady = this.playWhenReady
            release()
        }
        player = null
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

    override fun onDestroy() {
        player?.release()
        super.onDestroy()
    }

    override fun onStart() {
        super.onStart()
        initializePlayer()
    }

    override fun onResume() {
        super.onResume()
        hideSystemUi()
        initializePlayer()
    }

    @SuppressLint("InlinedApi")
    private fun hideSystemUi() {
        binding.player.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_LOW_PROFILE
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }
}