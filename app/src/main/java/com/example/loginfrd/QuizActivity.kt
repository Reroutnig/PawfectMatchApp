package com.example.loginfrd


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.collections.ArrayList

class QuizActivity : AppCompatActivity() {

    lateinit var questionsList: ArrayList<QuizActivityViewModel>
    private var index: Int = 0
    lateinit var questionModel: QuizActivityViewModel

    var optionCounts = IntArray(4)

    lateinit var questions: TextView
    lateinit var option1: Button
    lateinit var option2: Button
    lateinit var option3: Button
    lateinit var option4: Button

    private var backToast: Toast? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        supportActionBar?.hide()

        questions = findViewById(R.id.questions)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)

        //Listener for home button
        val homeButton = findViewById<Button>(R.id.homeButton)
        homeButton.setOnClickListener {
            startActivity(Intent(this@QuizActivity, MainActivity::class.java))
            finish()
        }

        questionsList = ArrayList()
        questionsList.add(
            QuizActivityViewModel(
                "What size dog do you prefer?",
                "Small",
                "Medium",
                "Large",
                "Extra Large"
            )
        )
        questionsList.add(
            QuizActivityViewModel(
                "How active is your lifestyle?",
                "Minimal",
                "Regular",
                "Active",
                "Very Active"
            )
        )
        questionsList.add(
            QuizActivityViewModel(
                "Who are you around?",
                "Elderly",
                "Younger kids",
                "Older kids",
                "Adults"
            )
        )
        questionsList.add(
            QuizActivityViewModel(
                "What's your grooming preference?",
                "Never",
                "Occasionally",
                "Monthly",
                "Biweekly"
            )
        )
        questionsList.add(
            QuizActivityViewModel(
                "How much experience do you have with dogs?",
                "None",
                "Little",
                "Experienced",
                "Very"
            )
        )


        //questionsList.shuffle()
        questionModel = questionsList[index]
        setAllQuestions()

    }
    private fun quizResult() {
        if (index >= questionsList.size) {
            val intent = Intent(this@QuizActivity, QuizResults::class.java)
            intent.putExtra("optionCounts", optionCounts)
            startActivity(intent)
        } else {
            questionModel = questionsList[index]
            setAllQuestions()
            enableButton()
        }
    }

        private fun setAllQuestions() {
        if (index < questionsList.size) {
            val currentQuestion = questionsList[index]
            questions.text = currentQuestion.question
            option1.text = currentQuestion.option1
            option2.text = currentQuestion.option2
            option3.text = currentQuestion.option3
            option4.text = currentQuestion.option4
        }
    }
    fun enableButton() {
        option1.isClickable = true
        option2.isClickable = true
        option3.isClickable = true
        option4.isClickable = true
    }

    fun disableButton() {
        option1.isClickable = false
        option2.isClickable = false
        option3.isClickable = false
        option4.isClickable = false
    }

    fun option1Clicked(view: View) {
        disableButton()
        optionCounts[0]++
        index++
        quizResult()
        setAllQuestions()
    }

    fun option2Clicked(view: View) {
        disableButton()
        optionCounts[1]++
        index++
        quizResult()
        setAllQuestions()
    }

    fun option3Clicked(view: View) {
        optionCounts[2]++
        index++
        quizResult()
        setAllQuestions()
    }

    fun option4Clicked(view: View) {
        optionCounts[3]++
        index++
        quizResult()
        setAllQuestions()
    }

}