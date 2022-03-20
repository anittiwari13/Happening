package com.example.newstoday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class SplashScreen : AppCompatActivity() {

    private lateinit var appname: TextView
    private lateinit var lottie: LottieAnimationView
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        appname = findViewById(R.id.appname)
        lottie = findViewById(R.id.lottie)

        //lottie.run { animate().translationX(-1400F).setDuration(2700).startDelay };

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}