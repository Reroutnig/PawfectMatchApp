package com.example.loginfrd



    import android.content.Intent
    import android.content.res.Resources
    import android.os.Bundle
    import android.widget.LinearLayout
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity

class QuizResults : AppCompatActivity() {


    lateinit var result:LinearLayout
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_results)
        supportActionBar?.hide()

        result = findViewById(R.id.result)
    }
    

    override fun onBackPressed() {
        var intent= Intent(this,QuizActivity::class.java)
        startActivity(intent)
    }
}
    