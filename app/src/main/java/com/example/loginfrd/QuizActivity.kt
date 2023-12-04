package com.example.loginfrd


import android.content.Intent
import android.os.Bundle
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

    var option1Count: Int = 0
    var option2Count: Int = 0
    var option3Count: Int = 0
    var option4Count: Int = 0

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
            var intent = Intent(this, QuizResults::class.java)

            intent.putExtra("total", questionsList.size.toString())

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
        option1Count++
        index++
        quizResult()
    }

    fun option2Clicked(view: View) {
        disableButton()
        option2Count++
        index++
        quizResult()
    }

    fun option3Clicked(view: View) {
        option3Count++
        index++
        quizResult()
    }

    fun option4Clicked(view: View) {
        option4Count++
        index++
        quizResult()
    }

}