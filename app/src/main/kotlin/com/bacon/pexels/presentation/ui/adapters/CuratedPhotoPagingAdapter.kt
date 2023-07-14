package com.bacon.pexels.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bacon.pexels.databinding.ItemCuratedPhotoBinding
import com.bacon.pexels.presentation.base.BaseDiffUtilItemCallback
import com.bacon.pexels.presentation.extensions.loadUrl
import com.bacon.pexels.presentation.models.PexelPhotoModelUI

class CuratedPhotoPagingAdapter(
    private val onItemClickListener: (id: Int) -> Unit
) : PagingDataAdapter<PexelPhotoModelUI, CuratedPhotoPagingAdapter.ViewHolder>(
    BaseDiffUtilItemCallback()
) {

    inner class ViewHolder(
        private val binding: ItemCuratedPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { onItemClickListener(it.id) }
            }
        }

        fun onBind(item: PexelPhotoModelUI) {
            binding.itemImageCurated.loadUrl(item.src.medium)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemCuratedPhotoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )
}