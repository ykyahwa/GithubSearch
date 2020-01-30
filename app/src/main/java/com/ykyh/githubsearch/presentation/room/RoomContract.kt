package com.ykyh.githubsearch.presentation.room

import com.ykyh.githubsearch.data.RoomData
import java.io.InputStream


interface RoomContract{
    interface RoomView {
        fun initView()
        fun setRoomList(data: List<RoomData>)
        fun setReservation(data: List<RoomData>)
    }

    interface RoomPresenter {
        fun takeView(view: RoomView)
        fun dropView()

        fun readJsonFile(inputStream: InputStream)
    }
}