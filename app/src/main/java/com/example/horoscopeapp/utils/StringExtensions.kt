package com.example.horoscopeapp.utils

import android.graphics.Color
import android.text.SpannableString
import android.text.style.BackgroundColorSpan


fun String.highlight(text: String) : SpannableString {
    val str = SpannableString(this)
    val startIndex = str.indexOf(text, 0, true)
    str.setSpan(BackgroundColorSpan(Color.CYAN), startIndex, startIndex + text.length, 0)
    return str
}