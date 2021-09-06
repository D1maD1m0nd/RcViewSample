package com.example.rcviewsample.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rcviewsample.R
import com.example.rcviewsample.databinding.ActiveUserItemBinding
import com.example.rcviewsample.databinding.UnactiveUserItemBinding
import com.example.rcviewsample.model.User
import com.example.rcviewsample.model.ViewHolderEnums

class UserAdapter(
) : RecyclerView.Adapter<BaseViewHolder>() {
    private var data: ArrayList<Pair<User, Boolean>> = ArrayList()

    fun setData(newData : List<Pair<User, Boolean>>) {
        data.addAll(newData)
        //notifyItemRangeInserted(0, newData.size)
        notifyDataSetChanged()
    }

    fun updateData(newData : List<Pair<User, Boolean>>) {
        val lastPos = itemCount
        data.addAll(newData)
        notifyItemRangeInserted(lastPos - 1, newData.size)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        Log.d("DEBUGGTAG", viewType.toString() )
        return  when(viewType) {
            ViewHolderEnums.USER.type -> UserActiveViewHolder(inflater.inflate(R.layout.active_user_item, parent, false) as View)
            ViewHolderEnums.UNUSER.type -> UserInactiveViewHolder(inflater.inflate(R.layout.unactive_user_item, parent, false) as View)
            else ->  UserActiveViewHolder(inflater.inflate(R.layout.active_user_item, parent, false) as View)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    override fun getItemId(position: Int): Long {
        return data[position].first.hashCode().toLong()
    }
    override fun getItemViewType(position: Int): Int {
        return when {
            position == 0 -> ViewHolderEnums.HEADER.type
            data[position].first.active -> ViewHolderEnums.USER.type
            data[position].first.active.not() -> ViewHolderEnums.UNUSER.type
            else -> ViewHolderEnums.FOOTER.type
        }
    }

    inner class UserActiveViewHolder(view : View) : BaseViewHolder(view) {
        private val binding: ActiveUserItemBinding = ActiveUserItemBinding.bind(view)
        override fun bind(dataItem: Pair<User, Boolean>) {
            binding.idUser.text  = dataItem.first.id.toString()
            binding.nameUser.text = dataItem.first.name  +  " " +dataItem.first.active
            binding.ageUser.text = dataItem.first.age.toString()
        }
    }

    inner class UserInactiveViewHolder(view : View) : BaseViewHolder(view) {
        private val binding: UnactiveUserItemBinding = UnactiveUserItemBinding.bind(view)
        override fun bind(dataItem: Pair<User, Boolean>) {

            binding.idUser.text  = dataItem.first.id.toString()
            binding.nameUser.text = dataItem.first.name  +  " " +dataItem.first.active
            binding.ageUser.text = dataItem.first.age.toString()
        }
    }

}