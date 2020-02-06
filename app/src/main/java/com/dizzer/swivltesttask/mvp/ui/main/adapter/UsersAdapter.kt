package com.dizzer.swivltesttask.mvp.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dizzer.swivltesttask.R
import com.dizzer.swivltesttask.mvp.models.UserModel
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter(private val mListener: OnUserClickListener ) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {
    private var context: Context? = null
    var models: List<UserModel> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_user, viewGroup, false)
        context = viewGroup.context
        return ViewHolder(view)
    }

    interface OnUserClickListener {
        fun onUserClick(position: Int)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(i)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            itemView.setOnClickListener { mListener.onUserClick(position) }
            if (context != null && models[position].avatar_url.isNullOrEmpty().not()) {
                Glide.with(context!!)
                    .load(models[position].avatar_url)
                    .apply(RequestOptions.circleCropTransform())
                    .into(itemView.iv_user_avatar)
            }
            itemView.tv_user_name.text = models[position].login
        }
    }
}
