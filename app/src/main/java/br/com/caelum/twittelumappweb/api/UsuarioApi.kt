package br.com.caelum.twittelumappweb.api

import br.com.caelum.twittelumappweb.modelo.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class UsuarioApi(retrofit: Retrofit) {

    private val service: UsuarioService by lazy {
        retrofit.create(UsuarioService::class.java)
    }

    fun salva(usuario: Usuario, lidaComSucesso: (Usuario) -> Unit) {

        val chamadaProServidor = service.cria(usuario)

        chamadaProServidor.enqueue(object : Callback<Usuario> {
            override fun onFailure(call: Call<Usuario>, t: Throwable) {

            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {

                response.body()?.let(lidaComSucesso)
            }
        })

    }
}