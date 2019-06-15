package br.com.caelum.twittelumappweb.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import br.com.caelum.twittelumappweb.api.UsuarioApi
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioRepository(private val api: UsuarioApi) {


    private val liveDataUsuario = MutableLiveData<Usuario>()


    fun usuario() = liveDataUsuario as LiveData<Usuario>

    fun salva(usuario: Usuario) {

        api.salva(usuario, lidaComSucesso())

    }

    fun loga(usuario: Usuario) {

        api.loga(usuario, lidaComSucesso())
    }

    private fun lidaComSucesso(): (Usuario) -> Unit {
        return { usuario: Usuario ->
            liveDataUsuario.postValue(usuario)
        }
    }

}
