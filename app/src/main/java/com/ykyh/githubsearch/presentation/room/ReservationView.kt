package com.ykyh.githubsearch.presentation.room

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.ykyh.githubsearch.R
import com.ykyh.githubsearch.data.RoomResrvation
import com.ykyh.githubsearch.utils.toPx
import kotlinx.android.synthetic.main.view_reservation.view.*
import timber.log.Timber


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
        val view = View(context)
        view.id = View.generateViewId()
        view.setBackgroundColor(ContextCompat.getColor(context, R.color.deep_sky_blue))
        addView(view)


        val startView = startView(startTime)
        val endView = endView(endTime)
        Timber.d("startView = $startView , endView = $endView")
        val constraintSet = ConstraintSet()
        constraintSet.clone(this)
        constraintSet.connect(view.id, ConstraintSet.TOP, vLine1.id, ConstraintSet.TOP, 0)
        constraintSet.connect(view.id, ConstraintSet.BOTTOM, vLine1.id, ConstraintSet.BOTTOM, 0)
        constraintSet.connect(view.id, ConstraintSet.START, startView.id, ConstraintSet.START, 0)
        constraintSet.connect(view.id, ConstraintSet.LEFT, startView.id, ConstraintSet.LEFT, 0)
        constraintSet.connect(view.id, ConstraintSet.END, endView.id, ConstraintSet.END, 0)
        constraintSet.connect(view.id, ConstraintSet.RIGHT, endView.id, ConstraintSet.RIGHT, 0)
        constraintSet.constrainWidth(view.id, ConstraintSet.MATCH_CONSTRAINT)
        constraintSet.constrainHeight(view.id, ConstraintSet.MATCH_CONSTRAINT)

        constraintSet.applyTo(this)

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