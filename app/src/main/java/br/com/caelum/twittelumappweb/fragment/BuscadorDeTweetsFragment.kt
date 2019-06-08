package br.com.caelum.twittelumappweb.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.SearchView
import android.view.*
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.adapter.TweetAdapter
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.lista_fragment.*

class BuscadorDeTweetsFragment : Fragment() {


    private val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(activity!!, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.lista_fragment, container, false)


        return view

    }


    override fun onCreateOptionsMenu(
            menu: Menu,
            inflater: MenuInflater
    ) {

        inflater.inflate(R.menu.menu_fragment_busca, menu)


        val itemDeBusca = menu.findItem(R.id.pesquisa_item)

        val search = itemDeBusca.actionView as SearchView


        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(texto: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(texto: String?): Boolean {

                if (!texto.isNullOrBlank()) {

                    val tweetsFiltrados = viewModel.filtraOsTweetsPelo(texto)

                    listaTweets.adapter = TweetAdapter(tweetsFiltrados)

                }

                return true
            }
        })


    }


}