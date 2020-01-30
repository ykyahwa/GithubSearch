package com.ykyh.githubsearch.presentation.room

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.ykyh.githubsearch.R
import com.ykyh.githubsearch.data.RoomResrvation
import kotlinx.android.synthetic.main.view_reservation.view.*


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

        for (reservation in reservations) {
            val startTime = reservation.startTime.substring(0,2).toInt()
            val endTime = reservation.endTime.substring(0,2).toInt()

            addReservation(startTime, endTime)

        }
    }

    private fun addReservation(startTime: Int, endTime: Int) {
        val v = View(context)
        v.id = View.generateViewId()
        v.setBackgroundColor(ContextCompat.getColor(context, R.color.deep_sky_blue))
        val newParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

//        param.startToStart = startView(startTime).id
//        param.endToEnd = endView(endTime).id
        newParams.startToStart = R.id.vLine1
        newParams.endToEnd = R.id.vLine2
        newParams.topToTop = R.id.vLine1
        newParams.bottomToBottom = R.id.vLine1


        val constraintSet = ConstraintSet()
        constraintSet.connect(vLine1.getId(), ConstraintSet.TOP, vLine1.getId(), ConstraintSet.BOTTOM, 0)
        constraintSet.connect(vLine1.getId(), ConstraintSet.LEFT, vLine2.getId(), ConstraintSet.RIGHT, 0)
        constraintSet.applyTo(this)
        addView(v, childCount, newParams)
    }

    private fun startView(startTime: Int) = when(startTime) {
        9 -> vLine1
        10 -> vLine2
        11 -> vLine3
        12 -> vLine4
        13 -> vLine5
        14 -> vLine6
        15 -> vLine7
        16 -> vLine8
        17 -> vLine9
        else -> throw IllegalArgumentException()
    }

    private fun endView(endTime: Int) = when(endTime) {
        10 -> vLine1
        11 -> vLine2
        12 -> vLine3
        13 -> vLine4
        14 -> vLine5
        15 -> vLine6
        16 -> vLine7
        17 -> vLine8
        18 -> vLine9
        else -> throw IllegalArgumentException()
    }
}