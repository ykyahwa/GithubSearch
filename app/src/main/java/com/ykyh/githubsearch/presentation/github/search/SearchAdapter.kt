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
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_search.view.*

class SearchAdapter()  : PagedListAdapter<GithubUserData, SearchAdapter.SearchHolder>(diffCallback) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<GithubUserData>() {
            override fun areItemsTheSame(oldItem: GithubUserData, newItem: GithubUserData): Boolean = false

            override fun areContentsTheSame(oldItem: GithubUserData, newItem: GithubUserData): Boolean = false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false))

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        getItem(position)?.let {item ->
            Glide.with(holder.containerView)
                .load(item.avatarUrl)
                .into(holder.ivProfile)

            holder.tvName.text = item.login
            holder.tvScore.text = item.score.toString()
        }
    }

    inner class SearchHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        val ivProfile = containerView.ivProfile
        val ivLike = containerView.ivLike
        val tvName = containerView.tvName
        val tvScore = containerView.tvScore
    }
}