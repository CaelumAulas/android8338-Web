package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.UsuarioRepository
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioViewModel(val repository: UsuarioRepository) : ViewModel() {

    fun salva(usuario: Usuario) = repository.salva(usuario)
    fun loga(usuario: Usuario) = repository.loga(usuario)

}
