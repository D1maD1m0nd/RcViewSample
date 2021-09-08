package com.example.rcviewsample.ui.user_rc_fragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rcviewsample.model.User

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(dataItem: Pair<User, Boolean>)
}
