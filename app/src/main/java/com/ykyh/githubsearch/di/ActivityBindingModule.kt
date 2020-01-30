package com.ykyh.githubsearch.di

import com.ykyh.githubsearch.presentation.github.GithubActivity
import com.ykyh.githubsearch.presentation.github.GithubModule
import com.ykyh.githubsearch.presentation.main.MainActivity
import com.ykyh.githubsearch.presentation.room.RoomActivity
import com.ykyh.githubsearch.presentation.room.RoomModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [GithubModule::class, FragmentModule::class])
    abstract fun githubActivity(): GithubActivity


    @ActivityScoped
    @ContributesAndroidInjector(modules = [RoomModule::class])
    abstract fun roomActivity(): RoomActivity
}