package com.ykyh.githubsearch.presentation.github.search

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

class SearchAdapter(val listener: GithubListener?, val clickLike: (Int, GithubUserData) -> Unit)  : PagedListAdapter<GithubUserData, SearchAdapter.SearchHolder>(diffCallback) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<GithubUserData>() {
            override fun areItemsTheSame(oldItem: GithubUserData, newItem: GithubUserData): Boolean = oldItem == newItem

            override fun areContentsTheSame(oldItem: GithubUserData, newItem: GithubUserData): Boolean = oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false))

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        getItem(position)?.let {item ->
            Glide.with(holder.itemView)
                .load(item.avatarUrl)
                .into(holder.ivProfile)

            holder.tvName.text = item.login
            holder.tvScore.text = item.score.toString()

            holder.ivLike.setOnClickListener {
                clickLike(position, item)
            }

            item.id?.let {id ->
                val isLike = listener?.isLike(item.id) ?: false
                if (isLike) {
                    holder.ivLike.setImageResource(R.drawable.like_enable)
                } else {
                    holder.ivLike.setImageResource(R.drawable.like_disable)
                }
            }
        }
    }

    inner class SearchHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        val ivProfile = itemView.ivProfile
        val ivLike = itemView.ivLike
        val tvName = itemView.tvName
        val tvScore = itemView.tvScore
    }
}