package com.example.apiapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // creating an intent to move to the next page

        val post = findViewById<Button>(R.id.post_btn)
        val get = findViewById<Button>(R.id.get_btn)
        val update = findViewById<Button>(R.id.update_btn)

        post.setOnClickListener {
            val x = Intent(applicationContext, Post_page::class.java)
            startActivity(x)
        }

        get.setOnClickListener {
            val x = Intent(applicationContext, GetEmployee::class.java)
            startActivity(x)
        }

        update.setOnClickListener {
            val x = Intent(applicationContext, UpdateEmployee::class.java)
            startActivity(x)
        }


    }
}