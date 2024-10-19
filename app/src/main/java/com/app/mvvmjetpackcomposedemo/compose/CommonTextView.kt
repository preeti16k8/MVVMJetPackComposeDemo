package com.app.mvvmjetpackcomposedemo.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CommonTextView(text: String) {
    Text(text, modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp), textAlign = TextAlign.Center)
}