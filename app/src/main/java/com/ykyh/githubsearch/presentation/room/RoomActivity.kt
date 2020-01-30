package com.ykyh.githubsearch.presentation.room

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.text.buildSpannedString
import androidx.core.text.color
import androidx.recyclerview.widget.RecyclerView
import com.ykyh.githubsearch.R
import com.ykyh.githubsearch.data.RoomData
import com.ykyh.githubsearch.utils.toPx
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_room.*
import timber.log.Timber
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class RoomActivity : DaggerAppCompatActivity(), RoomContract.RoomView{

    @Inject
    lateinit var presenter: RoomContract.RoomPresenter

    lateinit var roomListAdapter: RoomListAdapter
    lateinit var roomReservationAdapter: RoomReservationAdapter

    companion object {
        fun getStartIntent(context: Context) = Intent(context, RoomActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        presenter.takeView(this)
    }

    override fun initView() {
        initRecyclerView()

        requestRoomData()
    }

    private fun initRecyclerView() {
        roomListAdapter = RoomListAdapter()
        rvRoomList.adapter = roomListAdapter
        rvRoomList.addItemDecoration(object:  RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                val position = parent.getChildAdapterPosition(view)
                if (position == 0) {
                    outRect.left = 15.toPx
                } else {
                    outRect.left = 5.toPx
                }
            }
        })

        roomReservationAdapter = RoomReservationAdapter()
        rvRoomReservation.adapter = roomReservationAdapter

        rvRoomReservation.addItemDecoration(object:  RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.left = 15.toPx
                outRect.right = 15.toPx
                outRect.bottom = 10.toPx
            }
        })
    }

    private fun requestRoomData() {
        val source: InputStream?

        try {
            source = resources.assets.open("MUSINSA.json")
            Timber.d("source = $source")
            source.let {
                presenter.readJsonFile(it)
            }
        } catch (e: IOException) {
            Timber.d(e)
        }

    }

    override fun setRoomList(data: List<RoomData>) {
        roomListAdapter.items = data
        roomListAdapter.notifyDataSetChanged()
    }

    override fun setReservation(data: List<RoomData>) {
        Timber.d("setReservation = $data")
        roomReservationAdapter.items = data
        roomReservationAdapter.notifyDataSetChanged()
    }

    override fun setRoomCount(count: Int) {
        val text = buildSpannedString {
            append("현재 사용 가능 회의실 ")
            color(ContextCompat.getColor(this@RoomActivity, R.color.deep_sky_blue)) {
                append(count.toString())
            }
        }

        tvRoomTitle.text = text
    }
}