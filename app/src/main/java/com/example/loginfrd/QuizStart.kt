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
            setContentView(R.layout.activity_quiz)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}