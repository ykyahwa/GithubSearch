package com.ykyh.githubsearch.presentation.github

import androidx.paging.PagedList
import com.ykyh.githubsearch.data.GithubUserData


interface GithubContract{
    interface SearchView {
        fun initView()
        fun setListData(pagedList: PagedList<GithubUserData>?)
    }

    interface SearchPresenter {
        fun takeView(view: SearchView)
        fun dropView()

        fun searchUsers(keyword: String)


    }
}