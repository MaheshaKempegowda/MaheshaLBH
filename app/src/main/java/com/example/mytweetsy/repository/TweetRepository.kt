package com.example.mytweetsy.repository

import com.example.mytweetsy.api.TweetsyAPI
import com.example.mytweetsy.models.Tweet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.*
import java.util.Collections.emptyList
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyAPI: TweetsyAPI) {
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<Tweet>>(emptyList())
    val tweets: StateFlow<List<Tweet>>
        get() = _tweets

    //suspend fun getTweets(category:String){
    suspend fun getTweets(category:String){
        val response = tweetsyAPI.getTweets()
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }

    suspend fun getCategory(){
        val response = tweetsyAPI.getCategories()
        var list = response.body()
        var categoryList = ArrayList<String>()
        list?.forEach {
            it.text
            categoryList.add(it.category)
        }
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(categoryList)
        }
    }
}