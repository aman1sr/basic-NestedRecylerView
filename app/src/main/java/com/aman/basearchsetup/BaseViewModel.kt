package com.aman.basearchsetup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aman.basearchsetup.api.ApiClient
import com.aman.basearchsetup.model.TopHeadlinesResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BaseViewModel: ViewModel() {
    val networkService = ApiClient.networkService

    private val _data = MutableStateFlow<TopHeadlinesResponse?>(null)
    val data : StateFlow<TopHeadlinesResponse?> = _data

    init {
        fetchNewsData()
    }

    private fun fetchNewsData() {
        Log.d(TAG, "fetching news Data")
        viewModelScope.launch {
            val response = networkService.getTopHeadLines("us")
            response?.let {
                Log.w(TAG, "Data Fetched: "+ it.toString())
                _data.value = it
            }
        }
    }


}