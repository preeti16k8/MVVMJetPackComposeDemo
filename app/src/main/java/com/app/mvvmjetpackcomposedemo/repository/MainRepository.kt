package com.app.mvvmjetpackcomposedemo.repository

import com.app.mvvmjetpackcomposedemo.model.GetUsers
import com.app.mvvmjetpackcomposedemo.network.RetrofitBuilder

class MainRepository {
    suspend fun getUsers(): GetUsers {
        return RetrofitBuilder.apiService.getUsers()
    }
}