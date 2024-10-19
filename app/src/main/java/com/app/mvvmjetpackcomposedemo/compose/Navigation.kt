package com.app.mvvmjetpackcomposedemo.compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.mvvmjetpackcomposedemo.constant.*
import com.app.mvvmjetpackcomposedemo.model.HomeModel

@Composable
fun Navigation( list: List<HomeModel>) {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = HOME) {
        composable(HOME) {
            HomeScreen(list, navController = navController)
        }
        composable(ONLINE_DEAL) {
            OnlineDealScreen()
        }
        composable(REWARD) {
            RewardScreen()
        }
        composable(TRANSFER) {
            TransferScreen()
        }
        composable(REFILL) {
            RefillScanScreen()
        }
    }
}