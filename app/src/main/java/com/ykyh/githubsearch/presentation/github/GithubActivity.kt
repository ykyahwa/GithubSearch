package com.ykyh.githubsearch.presentation.github

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ykyh.githubsearch.R
import com.ykyh.githubsearch.presentation.github.like.LikeFragment
import com.ykyh.githubsearch.presentation.github.search.SearchFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_github.*

class GithubActivity: DaggerAppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, GithubActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github)

        initView()
    }

    private fun initView() {
        val adapter = GithubPagerAdapter(supportFragmentManager)
        vpGithub.adapter = adapter
    }


}

class GithubPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int) = when(position) {
        0 -> SearchFragment()
        else -> LikeFragment()
    }

    override fun getCount(): Int = 2

}