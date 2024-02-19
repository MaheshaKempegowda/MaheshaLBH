package com.example.mytweetsy.api

import com.example.mytweetsy.models.Tweet
import retrofit2.Response
import retrofit2.http.GET

interface TweetsyAPI {

//    @GET("/v3/b/64b3dd858e4aa6225ebf1315?meta=false")
//    suspend fun getTweets(@Header("X-JSON-path")category:String):Response<List<TweetListItem>>
//
//    @GET("/v3/b/64b3dd858e4aa6225ebf1315?meta=false")
//    suspend fun getCategories():Response<List<String>>

    //https://mocki.io/v1/25c6554d-f154-4b8d-8c5e-d5fd6bca17b2

    @GET("/v1/25c6554d-f154-4b8d-8c5e-d5fd6bca17b2")
    //suspend fun getTweets(category:String):Response<List<Tweet>>
    suspend fun getTweets():Response<List<Tweet>>

    @GET("/v1/25c6554d-f154-4b8d-8c5e-d5fd6bca17b2")
    suspend fun getCategories(): Response<List<Tweet>>

}