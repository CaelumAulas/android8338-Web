package br.com.caelum.twittelumappweb.gps

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.*

class GPS(context: Context) : LocationCallback() {

    private var location: Location? = null

    private val client: FusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    fun buscaLocalizacao() {

        val request = LocationRequest()

        request.apply {
            smallestDisplacement = 10.0F
            interval = 10 * 1000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        }

        client.requestLocationUpdates(request, this, null)
    }

    override fun onLocationResult(result: LocationResult) {

        location = result.lastLocation

    }


    fun getCoodernada(): Pair<Double, Double> {

        val latitude = location?.latitude
        val longitude = location?.longitude

        return Pair(latitude ?: 0.0, longitude ?: 0.0)

    }
}