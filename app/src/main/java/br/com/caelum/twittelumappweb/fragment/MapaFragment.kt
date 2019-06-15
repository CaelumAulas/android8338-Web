package br.com.caelum.twittelumappweb.fragment

import android.arch.lifecycle.ViewModelProviders
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapaFragment : SupportMapFragment(), OnMapReadyCallback {

    private val viewModel by lazy {
        ViewModelProviders.of(activity!!, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onMapReady(map: GoogleMap) {

        val tweets = viewModel.lista().value!!


        tweets.forEach { tweet ->

            val marker = MarkerOptions()

            marker.position(LatLng(tweet.latitude, tweet.longitude))
            marker.title(tweet.mensagem)

            map.addMarker(marker)

        }

    }

    override fun onResume() {
        super.onResume()

        getMapAsync(this)
    }
}