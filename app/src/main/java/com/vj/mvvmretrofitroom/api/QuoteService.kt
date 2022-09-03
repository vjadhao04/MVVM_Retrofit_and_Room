package com.vj.mvvmretrofitroom.api


import com.vj.mvvmretrofitroom.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface QuoteService {

    @GET("/z")
    suspend fun getQuote(@Query("page") page :Int): Response<QuoteList>
}