package br.com.caelum.twittelumappweb.data

import android.util.Log
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioRepository {
    fun salva(usuario: Usuario) {
        Log.i("salvando", "$usuario")
    }

    fun loga(usuario: Usuario) {
        Log.i("logando", "$usuario")

    }


}
