package com.bacon.pexels.presentation.ui.adapters

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bacon.pexels.databinding.ItemVideosBinding
import com.bacon.pexels.presentation.base.BaseDiffUtilItemCallback
import com.bacon.pexels.presentation.models.videos.PexelVideoModelUI
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

class VideosAdapter :
    ListAdapter<PexelVideoModelUI, VideosAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    inner class ViewHolder(
        private val binding: ItemVideosBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: PexelVideoModelUI) {
            Glide.with(itemView.context)
                .asBitmap()
                .load(item.image)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        binding.itemVideoPreview.setImageBitmap(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                    }
                })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemVideosBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}