package com.ykyh.githubsearch.presentation.github.like

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ykyh.githubsearch.R
import com.ykyh.githubsearch.presentation.github.GithubListener
import com.ykyh.githubsearch.presentation.github.search.SearchAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_like.*
import timber.log.Timber
import javax.inject.Inject

class LikeFragment @Inject constructor(): DaggerFragment() {

    private var listener: GithubListener? = null

    lateinit var adapter: LikeAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is GithubListener) {
            listener = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_like, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = LikeAdapter()
        rvList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()

        listener?.getLikeData()?.let {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }
    }
}