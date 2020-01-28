package com.ykyh.githubsearch.presentation.github.search

import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.ykyh.githubsearch.data.GithubUserData
import com.ykyh.githubsearch.presentation.github.GithubContract
import com.ykyh.githubsearch.repository.GithubRepository
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject


class SearchPresenter @Inject constructor(private val githubRepository: GithubRepository) : GithubContract.SearchPresenter{

    private var view: GithubContract.SearchView? = null

    private var compositeDisposable: CompositeDisposable? = null

    val config = PagedList.Config.Builder()
        .setPageSize(20)
        .setPrefetchDistance(3)
        .setEnablePlaceholders(true)
        .build()

    override fun takeView(view: GithubContract.SearchView) {
        this.view = view
        compositeDisposable = CompositeDisposable()

        view.initView()
    }

    override fun dropView() {
        compositeDisposable?.dispose()
        compositeDisposable = null
    }


    override fun searchUsers(keyword: String) {
        Timber.d("searchUsers -  %s",keyword)


        RxPagedListBuilder<Int, GithubUserData>(object : DataSource.Factory<Int, GithubUserData>() {
            override fun create(): DataSource<Int, GithubUserData> =
                SearchDataSource(githubRepository, keyword)
        }, config).apply{
            buildObservable().subscribe {
                view?.setListData(it)

            }.apply { compositeDisposable?.add(this) }
        }
    }
}