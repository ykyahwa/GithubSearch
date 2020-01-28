package com.ykyh.githubsearch.presentation.github.search

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.ykyh.githubsearch.repository.GithubRepository
import timber.log.Timber
import javax.inject.Inject


class SearchViewModel @Inject constructor(private val githubRepository: GithubRepository) : ViewModel() {


    var keyword: ObservableField<String> = ObservableField()

    fun clickSearch() {
        Timber.d("clickSearch -  %s",keyword.get())
        keyword.get()?.let {
            searchUsers(it)
        }
    }

    private fun searchUsers(keyword: String) {
        Timber.d("searchUsers -  %s",keyword)
        val api = githubRepository.searchUsers(keyword)
            .subscribe({

            }, {

            })
    }
}