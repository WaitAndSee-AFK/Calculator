package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textViewTheFirstNumber: TextView = findViewById(R.id.textViewTheFirstNumber)
        val textViewTheSecondNumber: TextView = findViewById(R.id.textViewTheSecondNumber)
        val editTextAnswer: EditText = findViewById(R.id.editTextAnswer)
        val buttonAnswer: Button = findViewById(R.id.buttonAnswer)
        val textViewIncorrectAnswer: TextView = findViewById(R.id.textViewIncorrectAnswer)
        val textViewCorrectAnswer: TextView = findViewById(R.id.textViewCorrectAnswer)


        var firstNumber: Int = Random.nextInt(100)
        var secondNumber: Int = Random.nextInt(100)

        fun updateNumbers() {
            textViewTheFirstNumber.text = firstNumber.toString()
            textViewTheSecondNumber.text = secondNumber.toString()
        }

        updateNumbers()

        buttonAnswer.setOnClickListener {
            val text = editTextAnswer.text.toString()
            if (text.equals((firstNumber + secondNumber).toString())) {
                textViewCorrectAnswer.visibility = View.VISIBLE
                textViewIncorrectAnswer.visibility = View.GONE

                firstNumber = Random.nextInt(100)
                secondNumber = Random.nextInt(100)

                updateNumbers()

                editTextAnswer.text.clear()

                textViewCorrectAnswer.postDelayed( {
                    textViewCorrectAnswer.visibility = View.GONE
                }, 2000)
            } else {
                textViewIncorrectAnswer.visibility = View.VISIBLE
                textViewCorrectAnswer.visibility = View.GONE
            }
        }
    }
}