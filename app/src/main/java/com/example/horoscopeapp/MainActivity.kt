package com.example.horoscopeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val horoscopeList: List<Horoscope> = listOf(
        Horoscope("aries", "Aries", 0),
        Horoscope("aries", "Taurus", 0),
        Horoscope("aries", "Gemini", 0),
        Horoscope("aries", "Cancer", 0),
        Horoscope("aries", "Leo", 0),
        Horoscope("aries", "Virgo", 0),
        Horoscope("aries", "Libra", 0),
        Horoscope("aries", "Scorpio", 0),
        Horoscope("aries", "Sagittarius", 0),
        Horoscope("aries", "Capricorn", 0),
        Horoscope("aries", "Aquarius", 0),
        Horoscope("aries", "Pisces", 0)

    )

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val adapter = HoroscopeAdapter(horoscopeList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}