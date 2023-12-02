package com.example.loginfrd



import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizResults : AppCompatActivity() {

    private var QuizActivity = QuizActivity()
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_results)
        supportActionBar?.hide()
        val maxOption = listOf(
            QuizActivity.option1Count,
            QuizActivity.option2Count,
            QuizActivity.option3Count,
            QuizActivity.option4Count
        ).max()

        val highestCountOption = when (maxOption) {
            QuizActivity.option1Count -> R.layout.quiz_results_chihuahua // Replace with your layout file for option 1
            QuizActivity.option2Count -> R.layout.quiz_results_beagle // Replace with your layout file for option 2
            QuizActivity.option3Count -> R.layout.quiz_results // Replace with your layout file for option 3
            QuizActivity.option4Count -> R.layout.quiz_results_german_shepard // Replace with your layout file for option 4
            else -> R.layout.quiz_results_beagle // Default layout if counts are equal or zero
        }

    }
    override fun onBackPressed() {
        var intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }
}



    