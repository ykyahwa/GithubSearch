package com.ykyh.githubsearch.presentation.github.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedList
import com.ykyh.githubsearch.R
import com.ykyh.githubsearch.data.GithubUserData
import com.ykyh.githubsearch.presentation.github.GithubContract
import com.ykyh.githubsearch.presentation.github.GithubListener
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject

class SearchFragment @Inject constructor(): DaggerFragment(), GithubContract.SearchView{

    @Inject
    lateinit var presenter: GithubContract.SearchPresenter

    lateinit var adapter: SearchAdapter

    private var listener: GithubListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is GithubListener) {
            listener = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.takeView(this)
    }

    override fun initView() {
        adapter = SearchAdapter(listener) { position, item ->
            listener?.clickLike(item)
            adapter.notifyItemChanged(position)
        }
        rvList.adapter = adapter


        btSearch.setOnClickListener {
            presenter.searchUsers(etSearch.text.toString())
        }

    }

    override fun setListData(pagedList: PagedList<GithubUserData>?) {
        adapter.submitList(pagedList)
    }


}