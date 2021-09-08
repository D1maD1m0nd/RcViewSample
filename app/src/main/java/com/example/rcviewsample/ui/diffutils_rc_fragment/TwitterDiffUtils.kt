package com.example.rcviewsample.ui.diffutils_rc_fragment

import androidx.recyclerview.widget.DiffUtil
import com.example.rcviewsample.model.Tweet

class TwitterDiffUtils(private val oldList: List<Tweet>, private val newList: List<Tweet>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].getId() == newList[newItemPosition].getId()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return false
    }
}