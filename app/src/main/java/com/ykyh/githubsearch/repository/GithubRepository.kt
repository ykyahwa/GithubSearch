package com.ykyh.githubsearch.repository

import com.ykyh.githubsearch.data.GIthubUserListData
import com.ykyh.githubsearch.network.GithubApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface GithubRepository {
    fun searchUsers(keyword: String) : Single<GIthubUserListData>
}

class GithubRepositoryImpl @Inject constructor(private val githubApi: GithubApi): GithubRepository {

    override fun searchUsers(keyword: String): Single<GIthubUserListData> =
        githubApi.getSearchUsers(keyword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}