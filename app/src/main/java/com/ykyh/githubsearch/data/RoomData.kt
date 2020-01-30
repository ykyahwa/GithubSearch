package com.ykyh.githubsearch.data

import com.google.gson.annotations.SerializedName

data class RoomData(
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: String,
    @SerializedName("reservations") val reservations: ArrayList<RoomResrvation>)

data class RoomResrvation (
    @SerializedName("startTime") val startTime: String,
    @SerializedName("endTime") val endTime: String)