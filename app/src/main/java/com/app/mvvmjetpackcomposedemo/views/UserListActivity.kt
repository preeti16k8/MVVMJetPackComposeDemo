package com.app.mvvmjetpackcomposedemo.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.app.mvvmjetpackcomposedemo.R
import com.app.mvvmjetpackcomposedemo.compose.UserListScreen
import com.app.mvvmjetpackcomposedemo.repository.MainRepository
import com.app.mvvmjetpackcomposedemo.utils.checkForInternet
import com.app.mvvmjetpackcomposedemo.viewmodel.MainViewModel
import com.app.mvvmjetpackcomposedemo.viewmodelfactory.MainViewModelFactory

class UserListActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        initObservers()
        callApi()
        setContent {
            UserListScreen(viewModel.getUserList)
        }
    }

    private fun initObservers() {
        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG)
                .show()
        }
    }


    private fun callApi() {
        if (checkForInternet(this)) {
            viewModel.getUsers()
        } else {
            Toast.makeText(this, getString(R.string.please_check_internet), Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun initViewModel() {
        val repository = MainRepository()
        val factory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

}






