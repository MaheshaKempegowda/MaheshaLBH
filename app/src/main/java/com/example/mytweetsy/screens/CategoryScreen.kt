package com.example.mytweetsy.screens

import android.annotation.SuppressLint
import com.example.mytweetsy.R
import android.util.Log.d
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytweetsy.viewmodels.CategoryViewModel

@Composable
fun CategoryScreen(onClick:(caregory:String) -> Unit) {
    //val categoryViewModel:CategoryViewModel = viewModel()
    val categoryViewModel:CategoryViewModel = hiltViewModel()
    val categories: State<List<String>> = categoryViewModel.categories.collectAsState()
    if (categories.value.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center) {
            Text(text = "Loading ......", style = MaterialTheme.typography.h3)
        }

    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            items(categories.value){
                CategoryScreenItem(caregory = it ,onClick)
            }
        }
    }
}

@Composable
fun CategoryScreenItem(caregory:String,onClick:(caregory:String) -> Unit) {
    Box(modifier = Modifier
        .padding(4.dp)
        .clickable { onClick(caregory) }
        .size(160.dp)
        .clip(RoundedCornerShape(8.dp))
        .paint(
            painter =
            painterResource(id = R.drawable.ic_wave_haikei),
            contentScale = ContentScale.Crop
        )
        .border(1.dp, Color.Gray),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = caregory,
            fontSize = 18.sp,
            color =Color.Black,
            modifier = Modifier.padding(0.dp,20.dp),
            style = MaterialTheme.typography.body1
        )
    }

}