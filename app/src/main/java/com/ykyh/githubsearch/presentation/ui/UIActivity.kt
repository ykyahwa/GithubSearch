package com.ykyh.githubsearch.presentation.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ykyh.githubsearch.R
import dagger.android.support.DaggerAppCompatActivity

class UIActivity : DaggerAppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, UIActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui)
    }
}