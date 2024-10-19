package com.app.mvvmjetpackcomposedemo.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mvvmjetpackcomposedemo.model.Data
import com.app.mvvmjetpackcomposedemo.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel()  {

    private val _getUserList = mutableStateListOf<Data>()
    val getUserList: List<Data>
        get() = _getUserList
    var errorMessage=MutableLiveData<String>()

    fun getUsers() {

        viewModelScope.launch {
            try {
                val response = repository.getUsers()
                _getUserList.clear()
                response.data?.let { _getUserList.addAll(it) }
            }catch (e: Exception){
                e.printStackTrace()
                errorMessage.value = e.message.toString()
            }

        }
    }
}