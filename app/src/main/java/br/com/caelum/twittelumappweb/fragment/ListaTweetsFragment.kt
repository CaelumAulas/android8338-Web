package br.com.caelum.twittelumappweb.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.adapter.TweetAdapter
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.lista_fragment.view.*

class ListaTweetsFragment : Fragment() {


    private val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(activity!!, ViewModelFactory).get(TweetViewModel::class.java)
    }


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View {


        val view = inflater.inflate(R.layout.lista_fragment, container, false)


        view.swipe.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_dark,
                android.R.color.holo_red_light
        )

        view.swipe.setOnRefreshListener {
            viewModel.buscaTweets()
        }

        viewModel.lista().observe(this, Observer { lista ->

            view.swipe.isRefreshing = false

            lista?.let {
                val adapter = TweetAdapter(lista)

                view.listaTweets.adapter = adapter
            }
        })




        return view


    }


}