package com.example.myapplication.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.RetrofitClient
import com.example.myapplication.network.Wellsitems
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class BaseViewModel : ViewModel() {
    private val _data = MutableLiveData<List<Wellsitems>>()
    val data: LiveData<List<Wellsitems>>
        get() = _data

    private val _internetConnection: MutableLiveData<Boolean>? = null
    val internetConnection: LiveData<Boolean>?
        get() = _internetConnection

    fun getList() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.retrofitService.wellsItemsList()
                val data = response.body()?.wellsites
                data?.let {
                    _data.postValue(it)
                }
            } catch (e: UnknownHostException) {
                _internetConnection?.postValue(false)
            }
        }

    }
}