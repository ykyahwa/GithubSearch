package com.ykyh.githubsearch.di

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun provideFragmentManager(fragment: Fragment) = fragment.childFragmentManager
}