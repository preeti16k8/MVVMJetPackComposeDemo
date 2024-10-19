package com.app.mvvmjetpackcomposedemo.network

import com.app.mvvmjetpackcomposedemo.constant.ServerConstant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(ServerConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}