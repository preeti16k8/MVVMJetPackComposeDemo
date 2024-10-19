package com.app.mvvmjetpackcomposedemo.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.app.mvvmjetpackcomposedemo.compose.CommonTextView
import com.app.mvvmjetpackcomposedemo.constant.IntentConstant
import com.app.mvvmjetpackcomposedemo.model.Data

class UserDetailActivity : ComponentActivity() {
    private lateinit var data: Data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (intent.hasExtra(IntentConstant.DATA)) {
            data = intent.getSerializableExtra(IntentConstant.DATA) as Data
        }
        setContent {
            UserDetailUI(data)
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun UserDetailUI(user: Data) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column {
            Image(
                painter = rememberImagePainter(user.avatar),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(120.dp)
            )
            CommonTextView(user.id.toString())
            CommonTextView(user.firstName + " " + user.lastName)
            user.email?.let { CommonTextView(it) }
            }
        }

}



