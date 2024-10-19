package com.app.mvvmjetpackcomposedemo.network

import com.app.mvvmjetpackcomposedemo.constant.ServerConstant
import com.app.mvvmjetpackcomposedemo.model.GetUsers
import retrofit2.http.GET

interface ApiService {

    /*
    To Get Users from Server
     */
    @GET(ServerConstant.GET_USER)
    suspend fun getUsers(): GetUsers
}