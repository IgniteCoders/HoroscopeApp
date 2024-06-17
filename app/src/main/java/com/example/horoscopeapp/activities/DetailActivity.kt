package com.example.horoscopeapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.horoscopeapp.R
import com.example.horoscopeapp.data.Horoscope
import com.example.horoscopeapp.data.HoroscopeProvider
import com.example.horoscopeapp.utils.SessionManager


class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_HOROSCOPE_ID = "HOROSCOPE_ID"
    }

    lateinit var horoscope: Horoscope
    var isFavorite = false

    lateinit var imageView: ImageView
    lateinit var textView: TextView

    lateinit var favoriteMenuItem: MenuItem

    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        session = SessionManager(this)

        val id: String = intent.getStringExtra(EXTRA_HOROSCOPE_ID)!!

        horoscope = HoroscopeProvider.findById(id)!!

        isFavorite = session.getFavoriteHoroscope()?.equals(horoscope.id) ?: false

        textView = findViewById(R.id.textView)
        imageView = findViewById(R.id.imageView)

        textView.setText(horoscope.name)
        imageView.setImageResource(horoscope.logo)
    }

    fun setFavoriteIcon () {
        if (isFavorite) {
            favoriteMenuItem.setIcon(R.drawable.ic_favorite_selected)
        } else {
            favoriteMenuItem.setIcon(R.drawable.ic_favorite)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_activity_detail, menu)
        favoriteMenuItem = menu.findItem(R.id.menu_favorite)
        setFavoriteIcon()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_favorite -> {
                if (isFavorite) {
                    session.setFavoriteHoroscope("")
                } else {
                    session.setFavoriteHoroscope(horoscope.id)
                }
                isFavorite = !isFavorite
                setFavoriteIcon()
                true
            }
            R.id.menu_share -> {
                val sendIntent = Intent()
                sendIntent.setAction(Intent.ACTION_SEND)
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                sendIntent.setType("text/plain")

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}