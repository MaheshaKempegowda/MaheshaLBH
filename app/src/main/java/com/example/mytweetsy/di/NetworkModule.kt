package com.example.mytweetsy.di

import com.example.mytweetsy.api.TweetsyAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit():Retrofit {
        // return Retrofit.Builder().baseUrl("https://api.jsonbin.io/")
        return Retrofit.Builder().baseUrl("https://mocki.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    // https://mocki.io/v1/f2578658-616b-44ee-b13f-0d7073673e4f
    //https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8
    @Singleton
    @Provides
  fun providesTweetsyAPI(retrofit: Retrofit): TweetsyAPI{
      return retrofit.create(TweetsyAPI::class.java)
  }
}