package com.example.mytweetsy.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytweetsy.models.Tweet
import com.example.mytweetsy.viewmodels.CategoryViewModel
import com.example.mytweetsy.viewmodels.DetailVewModel

@Composable
fun detailScreen() {
    val detailVewModel:DetailVewModel = hiltViewModel()

    val tweets: State<List<Tweet>> = detailVewModel.tweets.collectAsState()
    LazyColumn(content = {
        items(tweets.value){
            TweetListItem(tweets = it.text)
        }
    })

}

@Composable
fun TweetListItem(tweets:String) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        content = {
            Text(text = tweets,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.body2
            )
        }
    )
}