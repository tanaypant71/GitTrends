package com.example.gittrends

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories")   // HTTP GET request to the "search/repositories" endpoint
    suspend fun getRepos(@Query(value = "q")query: String = "trending", // Query parameter for search , default is "trending"
                         @Query(value = "sort")sort: String = "stars",  // Query parameter for sorting , default is "stars"
                         @Query(value = "order")order : String = "desc") // Query parameter for ordering , default is "desc"
    : Response<Repos>   //Retrofit Response containing a list of repositories i.e. Repos
}