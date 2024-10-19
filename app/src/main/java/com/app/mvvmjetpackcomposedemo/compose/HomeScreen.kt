package com.app.mvvmjetpackcomposedemo.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.mvvmjetpackcomposedemo.R
import com.app.mvvmjetpackcomposedemo.constant.ONLINE_DEAL
import com.app.mvvmjetpackcomposedemo.constant.REFILL
import com.app.mvvmjetpackcomposedemo.constant.REWARD
import com.app.mvvmjetpackcomposedemo.constant.TRANSFER
import com.app.mvvmjetpackcomposedemo.model.HomeModel
import com.app.mvvmjetpackcomposedemo.ui.theme.GreenButton
import com.app.mvvmjetpackcomposedemo.ui.theme.TextWhite

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(list: List<HomeModel>, navController: NavController) {
    Scaffold {

        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)) {
                Image(
                    painterResource(R.drawable.nature),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black)
                    )))
                Column(modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Protect yourself and \n your family",
                        fontSize = 24.sp,
                        color = TextWhite,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Schedule covid-19, flu and other vaccines",
                        fontSize = 18.sp,
                        color = TextWhite,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp, 8.dp),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.textButtonColors(
                            backgroundColor = GreenButton
                        )
                    ) {
                        Text("Schedule Appointment", color = TextWhite, fontSize = 18.sp)
                    }
                }

            }
            LazyVerticalGrid(cells = GridCells.Fixed(2)) {
                items(list.size) { index ->
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(8.dp, 16.dp)
                            .fillMaxWidth(),
                        elevation = 4.dp
                    ) {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp)
                            .clickable {
                                when (index) {
                                    0 ->
                                        navController.navigate(ONLINE_DEAL)
                                    1 ->
                                        navController.navigate(REWARD)
                                    2 ->
                                        navController.navigate(TRANSFER)
                                    3 ->
                                        navController.navigate(REFILL)
                                }
                            }) {

                            Icon(
                                imageVector = list[index].icon,
                                contentDescription = list[index].title,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                modifier = Modifier.fillMaxSize(),
                                text = list[index].title,
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp
                            )
                        }

                    }

                }
            }

        }
    }
}

