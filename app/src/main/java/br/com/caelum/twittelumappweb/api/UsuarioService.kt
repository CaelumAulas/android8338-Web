package br.com.caelum.twittelumappweb.api

import br.com.caelum.twittelumappweb.modelo.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UsuarioService {

    @POST("/usuario")
    fun cria(@Body usuario: Usuario): Call<Usuario>
}