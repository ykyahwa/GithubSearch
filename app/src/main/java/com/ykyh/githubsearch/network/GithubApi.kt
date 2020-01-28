package com.ykyh.githubsearch.network

import com.ykyh.githubsearch.data.GIthubUserListData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface GithubApi {
    @GET("/search/users")
    fun getSearchUsers(@Query("q") keyword: String): Single<GIthubUserListData>
}