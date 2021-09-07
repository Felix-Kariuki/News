package com.example.news.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.news.ui.activities.MainActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val time: Long = 3000

        Handler(Looper.myLooper()!!).postDelayed({
            val intent  = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        },time)
    }
}