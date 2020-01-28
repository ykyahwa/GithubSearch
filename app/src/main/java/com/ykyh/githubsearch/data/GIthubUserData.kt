package com.ykyh.githubsearch.data

import com.google.gson.annotations.SerializedName

data class GIthubUserListData(
    @SerializedName("incomplete_results") val incompleteResults: Boolean?,
    @SerializedName("items") val items: List<GithubUserData>?,
    @SerializedName("total_count") val totalCount: Int?
)

data class GithubUserData(
    @SerializedName("avatar_url") val avatarUrl: String?,
    @SerializedName("followers_url") val followersUrl: String?,
    @SerializedName("gravatar_id") val gravatarId: String?,
    @SerializedName("html_url") val htmlUrl: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("login") val login: String?,
    @SerializedName("node_id") val nodeId: String?,
    @SerializedName("organizations_url") val organizationsUrl: String?,
    @SerializedName("received_events_url") val receivedEventsUrl: String?,
    @SerializedName("repos_url") val reposUrl: String?,
    @SerializedName("score") val score: Double?,
    @SerializedName("subscriptions_url") val subscriptionsUrl: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("url") val url: String?
)