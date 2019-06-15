package br.com.caelum.twittelumappweb.data

import android.arch.lifecycle.MutableLiveData
import br.com.caelum.twittelumappweb.api.TweetApi
import br.com.caelum.twittelumappweb.modelo.Tweet

class TweetRepository(private val api: TweetApi) {

    fun salva(tweet: Tweet) {

        api.salva(tweet)

    }
    val lista = MutableLiveData<List<Tweet>>()


    fun buscaTweets() = api.getTweets { tweets ->
        lista.postValue(tweets)
    }

}