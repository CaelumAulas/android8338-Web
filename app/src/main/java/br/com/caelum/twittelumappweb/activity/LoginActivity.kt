package br.com.caelum.twittelumappweb.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.viewmodel.UsuarioViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    private val viewModel: UsuarioViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(UsuarioViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel.usuarioLogado().observe(this, Observer {
            startActivity(Intent(this, MainActivity::class.java))
        })


        login_criar.setOnClickListener {

            val usuario = pegaUsuarioDaTela()

            viewModel.salva(usuario)

        }
        login_entrar.setOnClickListener {

            val usuario = pegaUsuarioDaTela()

            viewModel.loga(usuario)

        }
    }

    private fun pegaUsuarioDaTela(): Usuario {

        val nome = login_campoNome.text.toString()
        val username = login_campoUsername.text.toString()
        val senha = login_campoSenha.text.toString()

        return Usuario(nome = nome, username = username, senha = senha)

    }
}