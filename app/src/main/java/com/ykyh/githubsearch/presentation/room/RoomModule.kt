package com.ykyh.githubsearch.presentation.room

import com.ykyh.githubsearch.di.ActivityScoped
import com.ykyh.githubsearch.network.GithubApi
import com.ykyh.githubsearch.presentation.github.like.LikeFragment
import com.ykyh.githubsearch.presentation.github.search.SearchFragment
import com.ykyh.githubsearch.presentation.github.search.SearchPresenter
import com.ykyh.githubsearch.repository.GithubRepository
import com.ykyh.githubsearch.repository.GithubRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit

@Module
 class RoomModule {

    @ActivityScoped
    @Provides
    fun provideRoomPresenter(): RoomContract.RoomPresenter {
        return RoomPresenter()
    }

}