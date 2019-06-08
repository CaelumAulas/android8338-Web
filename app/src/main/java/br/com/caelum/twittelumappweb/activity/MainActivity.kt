package br.com.caelum.twittelumappweb.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.fragment.BuscadorDeTweetsFragment
import br.com.caelum.twittelumappweb.fragment.ListaTweetsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.menu_lista -> mostra(ListaTweetsFragment())

                R.id.menu_busca -> mostra(BuscadorDeTweetsFragment())

                R.id.menu_mapa -> mostra(Fragment())
            }
            return@setOnNavigationItemSelectedListener true
        }

        bottomNavigation.selectedItemId = R.id.menu_lista
    }

    private fun mostra(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.frame, fragment)

        transaction.commit()
    }
}
