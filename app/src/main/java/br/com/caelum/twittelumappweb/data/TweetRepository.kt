package br.com.caelum.twittelumappweb.data

import br.com.caelum.twittelumappweb.modelo.Tweet

class TweetRepository {

    fun salva(tweet: Tweet) {}
    fun lista() = arrayListOf(
            Tweet("Tweet"),
            Tweet("A galera ta com sono"),
            Tweet("Bora acorrrrrdaaar")
    )

}