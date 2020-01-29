package com.ykyh.githubsearch.presentation.main

import android.os.Bundle
import com.ykyh.githubsearch.R
import com.ykyh.githubsearch.presentation.github.GithubActivity
import com.ykyh.githubsearch.presentation.ui.UIActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        btGithub.setOnClickListener {
            startActivity(GithubActivity.getStartIntent(this))
        }

        btUI.setOnClickListener {
            startActivity(UIActivity.getStartIntent(this))
        }
    }
}
