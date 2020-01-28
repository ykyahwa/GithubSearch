package com.ykyh.githubsearch.presentation.github.search

import androidx.paging.PageKeyedDataSource
import com.ykyh.githubsearch.data.GIthubUserListData
import com.ykyh.githubsearch.data.GithubUserData
import com.ykyh.githubsearch.repository.GithubRepository
import io.reactivex.Single
import timber.log.Timber

class SearchDataSource(
    private val githubRepository: GithubRepository,
    private val keyword: String):  PageKeyedDataSource<Int, GithubUserData>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, GithubUserData>) {
        getApi(null)
            ?.subscribe({
                callback.onResult(it.items, null, 2)
            }, {
                Timber.d(it)
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, GithubUserData>) {
        val pageNumber = params.key

        getApi(pageNumber)
            ?.subscribe({
                callback.onResult(it.items, pageNumber + 1)
            }, {
                Timber.d(it)
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, GithubUserData>) {
    }

    private fun getApi(page: Int?) : Single<GIthubUserListData>? =
        githubRepository.searchUsers(keyword, page)

}