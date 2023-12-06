package com.example.loginfrd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class QuizStart : AppCompatActivity() {

    lateinit var start:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_start)
        supportActionBar?.hide()

        start = findViewById(R.id.start)
        start.setOnClickListener {
            startActivity(Intent(this@QuizStart, QuizActivity::class.java))
        }

        //Listener for home button
        val homeButton = findViewById<Button>(R.id.homeButton)
        homeButton.setOnClickListener {
            startActivity(Intent(this@QuizStart, MainActivity::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}