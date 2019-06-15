package br.com.caelum.twittelumappweb.api

import br.com.caelum.twittelumappweb.modelo.Tweet
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TweetService {

    @GET("/tweet")
    fun buscaTweets(): Call<List<Tweet>>

    @POST("/tweet")
    fun salva(@Body tweet: Tweet): Call<Tweet>

}