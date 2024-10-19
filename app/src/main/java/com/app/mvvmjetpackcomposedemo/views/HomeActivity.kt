package com.app.mvvmjetpackcomposedemo.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import com.app.mvvmjetpackcomposedemo.R
import com.app.mvvmjetpackcomposedemo.compose.Navigation
import com.app.mvvmjetpackcomposedemo.model.HomeModel

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation(getList())
        }
    }
    
    private fun getList(): ArrayList<HomeModel> {
        val list = ArrayList<HomeModel>()
        list.add(HomeModel(icon = Icons.Default.Home,getString(R.string.online_deals)))
        list.add(HomeModel(icon = Icons.Default.Call,getString(R.string.rewards)))
        list.add(HomeModel(icon = Icons.Default.Settings,getString(R.string.transfer_rx)))
        list.add(HomeModel(icon = Icons.Default.AccountCircle,getString(R.string.refill_by_scan)))
        return list
    }
}




