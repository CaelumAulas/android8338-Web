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

    private fun lidaComSucesso(): (Usuario) -> Unit {
        return { usuario: Usuario ->
            liveDataUsuario.postValue(usuario)
        }
    }

    fun loga(usuario: Usuario) {
        Log.i("logando", "$usuario")

    }


}
