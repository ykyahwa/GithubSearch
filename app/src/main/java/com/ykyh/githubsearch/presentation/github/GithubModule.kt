package com.ykyh.githubsearch.presentation.github

import androidx.lifecycle.ViewModel
import com.ykyh.githubsearch.di.ActivityScoped
import com.ykyh.githubsearch.di.ViewModelBuilder
import com.ykyh.githubsearch.di.ViewModelKey
import com.ykyh.githubsearch.network.GithubApi
import com.ykyh.githubsearch.presentation.github.like.LikeFragment
import com.ykyh.githubsearch.presentation.github.search.SearchFragment
import com.ykyh.githubsearch.presentation.github.search.SearchViewModel
import com.ykyh.githubsearch.repository.GithubRepository
import com.ykyh.githubsearch.repository.GithubRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
abstract class GithubModule {
    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun searchFragment(): SearchFragment

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(viewmodel: SearchViewModel): ViewModel

    @ContributesAndroidInjector(modules = [
//        ViewModelBuilder::class
    ])
    internal abstract fun likeFragment(): LikeFragment

    @ActivityScoped
    @Binds
    abstract fun providegithubRepository(githubRepository: GithubRepositoryImpl) : GithubRepository

    @Module
    companion object {

        @ActivityScoped
        @JvmStatic
        @Provides
        fun provideGithubApi(retrofit: Retrofit): GithubApi = retrofit.create(GithubApi::class.java)
    }

}