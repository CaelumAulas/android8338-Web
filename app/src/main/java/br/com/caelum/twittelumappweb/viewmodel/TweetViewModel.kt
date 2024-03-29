package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.modelo.Tweet

class TweetViewModel(private val repository: TweetRepository) : ViewModel() {


    fun salva(tweet: Tweet) = repository.salva(tweet)
    fun lista() = repository.lista
    fun filtraOsTweetsPelo(texto: String): List<Tweet> {

        val lista = lista().value!!

        return lista.filter { tweet -> tweet.mensagem.contains(texto, true) }
    }

    fun buscaTweets() = repository.buscaTweets()

}