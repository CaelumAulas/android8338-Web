package br.com.caelum.twittelumappweb.api

import br.com.caelum.twittelumappweb.modelo.Tweet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class TweetApi(retrofit: Retrofit) {

    private val service: TweetService by lazy {
        retrofit.create(TweetService::class.java)
    }

    fun getTweets(lidaComLista: (List<Tweet>) -> Unit) {
        val chamadaParaBuscarTweets = service.buscaTweets()

        chamadaParaBuscarTweets.enqueue(object : Callback<List<Tweet>?> {
            override fun onFailure(call: Call<List<Tweet>?>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Tweet>?>, response: Response<List<Tweet>?>) {

                response.body()?.let(lidaComLista)
            }
        })

    }

    fun salva(tweet: Tweet) {

        service.salva(tweet).enqueue(object : Callback<Tweet?> {
            override fun onFailure(call: Call<Tweet?>, t: Throwable) {

            }

            override fun onResponse(call: Call<Tweet?>, response: Response<Tweet?>) {
            }
        })
    }
}











