package com.example.apiapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

// also in the manifest remember to specify the launcher that will be used for the application

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // have the handler that will enable you to have the delays in terms of seconds
        Handler().postDelayed({
            //create a link to where the screen should take you after a given time, for our case we will be taken to the main activity page
            val x = Intent(applicationContext, MainActivity::class.java)
            startActivity(x)
            finish() //finish the splash screen indefinitely
        }, 3000)

    }
}