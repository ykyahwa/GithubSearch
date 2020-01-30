package com.ykyh.githubsearch.presentation.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ykyh.githubsearch.R
import com.ykyh.githubsearch.data.RoomData
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_room_list.view.*

class RoomListAdapter : RecyclerView.Adapter<RoomListAdapter.RoomListHolder>() {

    var items: List<RoomData> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RoomListHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_room_list, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RoomListHolder, position: Int) {
        val item = items[position]

        holder.tvRoomName.text = item.name
    }

    inner class RoomListHolder(itemView: View): RecyclerView.ViewHolder(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        val tvRoomName = itemView.tvRoomName
    }
}