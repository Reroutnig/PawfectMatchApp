package com.example.loginfrd



import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class QuizResults : AppCompatActivity() {

    private var QuizActivity = QuizActivity()
    lateinit var result: TextView
    lateinit var continuebtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_results)
        supportActionBar?.hide()

        val intent = intent
        val optionCounts = intent.getIntArrayExtra("optionCounts") ?: IntArray(4)
        val maxOption = optionCounts.max()
        Log.d("MaxOption", "The max option count is: $maxOption")

        findViewById<ConstraintLayout>(R.id.layoutChihuahua).visibility = View.GONE
        findViewById<ConstraintLayout>(R.id.layoutBeagle).visibility = View.GONE
        findViewById<ConstraintLayout>(R.id.layoutLabrador).visibility = View.GONE
        findViewById<ConstraintLayout>(R.id.layoutGermanShepherd).visibility = View.GONE

        when (maxOption) {
            optionCounts[0] -> findViewById<ConstraintLayout>(R.id.layoutChihuahua).visibility = View.VISIBLE
            optionCounts[1] -> findViewById<ConstraintLayout>(R.id.layoutBeagle).visibility = View.VISIBLE
            optionCounts[2] -> findViewById<ConstraintLayout>(R.id.layoutLabrador).visibility = View.VISIBLE
            optionCounts[3] -> findViewById<ConstraintLayout>(R.id.layoutGermanShepherd).visibility = View.VISIBLE
        }

        continuebtn = findViewById(R.id.continuebtn)
        continuebtn.setOnClickListener {
            Log.d("ButtonClicked", "Continue button clicked")
            startActivity(Intent(this@QuizResults, CatalogActivity::class.java))
        }

    }
    override fun onBackPressed() {
        var intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }
}



    