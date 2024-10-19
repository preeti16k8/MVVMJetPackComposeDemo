package com.app.mvvmjetpackcomposedemo.compose

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.app.mvvmjetpackcomposedemo.constant.IntentConstant
import com.app.mvvmjetpackcomposedemo.model.Data
import com.app.mvvmjetpackcomposedemo.views.UserDetailActivity

@Composable
fun UserListScreen(userList: List<Data>) {
    val context = LocalContext.current
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(userList) { user ->
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clickable {
                        val intent = Intent(context, UserDetailActivity::class.java)
                        intent.putExtra(IntentConstant.DATA, user)
                        context.startActivity(intent)
                    }
            ) {
                Column {
                    CommonTextView(user.id.toString())
                    CommonTextView(user.firstName + " " + user.lastName)
                    user.email?.let { CommonTextView(it) }

                }
            }
        }
    }
}