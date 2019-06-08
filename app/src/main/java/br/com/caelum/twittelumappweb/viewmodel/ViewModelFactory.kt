package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.data.UsuarioRepository
import java.lang.RuntimeException

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private fun repository() = TweetRepository()

    private val usuarioRepository = UsuarioRepository()

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return if (modelClass == TweetViewModel::class.java) {
            TweetViewModel(repository()) as T
        } else {
            UsuarioViewModel(usuarioRepository) as T
        }
    }


}