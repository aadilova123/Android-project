package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.SharedPreferences

val APP_PREFERENCES = "mysettings" // имя файла для shared preferences
val TOKEN_KEY = "token"
lateinit var pref: SharedPreferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
