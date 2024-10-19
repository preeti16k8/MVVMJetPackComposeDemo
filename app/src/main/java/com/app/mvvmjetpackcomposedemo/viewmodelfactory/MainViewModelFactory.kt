package com.app.mvvmjetpackcomposedemo.viewmodelfactory


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.mvvmjetpackcomposedemo.repository.MainRepository
import com.app.mvvmjetpackcomposedemo.viewmodel.MainViewModel

class MainViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}