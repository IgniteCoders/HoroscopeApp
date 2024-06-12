package com.example.horoscopeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getStringExtra("HOROSCOPE_ID")

        val name = intent.getIntExtra("HOROSCOPE_NAME", -1)
        val logo = intent.getIntExtra("HOROSCOPE_LOGO", -1)

        findViewById<TextView>(R.id.textView).setText(name)
        findViewById<ImageView>(R.id.imageView).setImageResource(logo)
    }
}