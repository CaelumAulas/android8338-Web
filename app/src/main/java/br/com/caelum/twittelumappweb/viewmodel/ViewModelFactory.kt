package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caelum.twittelumappweb.api.InicializadorDoRetrofit
import br.com.caelum.twittelumappweb.api.UsuarioApi
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.data.UsuarioRepository
import java.lang.RuntimeException

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private fun repository() = TweetRepository()

    private val retrofit = InicializadorDoRetrofit.retrofit

    private val usuarioApi = UsuarioApi(retrofit)

    private val usuarioRepository = UsuarioRepository(usuarioApi)

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return if (modelClass == TweetViewModel::class.java) {
            TweetViewModel(repository()) as T
        } else {
            UsuarioViewModel(usuarioRepository) as T
        }
    }


}