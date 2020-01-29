package com.ykyh.githubsearch.presentation.github.like

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ykyh.githubsearch.R
import com.ykyh.githubsearch.data.GithubUserData
import com.ykyh.githubsearch.presentation.github.GithubListener
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_search.view.*

class LikeAdapter : RecyclerView.Adapter<LikeAdapter.LikeHolder>() {

    var items: List<GithubUserData> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LikeHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false))

    override fun onBindViewHolder(holder: LikeHolder, position: Int) {
        val item = items[position]

        Glide.with(holder.itemView)
            .load(item.avatarUrl)
            .into(holder.ivProfile)

        holder.tvName.text = item.login
        holder.tvScore.text = item.score.toString()
        holder.ivLike.setImageResource(R.drawable.like_enable)
    }

    override fun getItemCount() = items.size

    inner class LikeHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        val ivProfile = itemView.ivProfile
        val ivLike = itemView.ivLike
        val tvName = itemView.tvName
        val tvScore = itemView.tvScore
    }


}