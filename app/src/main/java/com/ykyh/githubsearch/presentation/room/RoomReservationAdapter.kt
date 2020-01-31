package com.ykyh.githubsearch.presentation.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ykyh.githubsearch.R
import com.ykyh.githubsearch.data.RoomData
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_room_reservation.view.*
import timber.log.Timber


class RoomReservationAdapter : RecyclerView.Adapter<RoomReservationAdapter.RoomReservationHolder>() {

    var items: List<RoomData> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RoomReservationHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_room_reservation, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RoomReservationHolder, position: Int) {
        Timber.d("onBindViewHolder")
        val item = items[position]

        holder.tvRoomName.text = item.name
        holder.tvLocation.text = item.location
        holder.reservationView.setReservation(item.reservations)
    }

    inner class RoomReservationHolder(itemView: View): RecyclerView.ViewHolder(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        val tvRoomName = itemView.tvRoomName
        val tvLocation = itemView.tvLocation
        val reservationView = itemView.reservationView
    }
}