package com.example.gittrends

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//In kotlin object is used to create anonymous classes
// which are useful for one time use
object Client {  //object is used to manage Retrofit config for network request
    private val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()   //Customizing Gson for JSON parsing

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")    //Base URL for Github API
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()    //Use Gson for JSON conversion

    val api = retrofit.create(GithubService::class.java)    //Creating API service using Retrofit
}