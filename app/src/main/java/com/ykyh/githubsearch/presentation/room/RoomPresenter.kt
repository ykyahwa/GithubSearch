package com.ykyh.githubsearch.presentation.room

import com.google.gson.Gson
import com.ykyh.githubsearch.data.RoomData
import timber.log.Timber
import java.io.InputStream
import java.io.InputStreamReader


class RoomPresenter: RoomContract.RoomPresenter {

    private var view: RoomContract.RoomView? = null

    override fun takeView(view: RoomContract.RoomView) {
        this.view = view
        view.initView()
    }

    override fun dropView() {
    }

    override fun readJsonFile(inputStream: InputStream) {
        val reader = InputStreamReader(inputStream)

        val data = Gson().fromJson(reader,  Array<RoomData>::class.java).toList()

        Timber.d("data = $data")

        view?.setRoomList(data)
        view?.setReservation(data)
    }
}