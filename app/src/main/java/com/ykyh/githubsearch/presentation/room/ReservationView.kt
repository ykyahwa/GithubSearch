package com.ykyh.githubsearch.presentation.room

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.ykyh.githubsearch.R
import com.ykyh.githubsearch.data.RoomResrvation

class ReservationView  @JvmOverloads constructor(context: Context,
                                                 attrs: AttributeSet? = null,
                                                 defStyleAttr: Int = 0): ConstraintLayout(context, attrs, defStyleAttr) {
    init {
        initView()
    }

    private fun initView() {
        View.inflate(context, R.layout.view_reservation, this)
    }

    fun setReservation(reservations: ArrayList<RoomResrvation>) {


    }
}