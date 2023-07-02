package com.example.hw1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextHeight: EditText
    private lateinit var editTextWeight: EditText
    private lateinit var editTextAge: EditText
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextHeight = findViewById(R.id.editTextHeight)
        editTextWeight = findViewById(R.id.editTextWeight)
        editTextAge = findViewById(R.id.editTextAge)
        textViewResult = findViewById(R.id.textViewResult)

        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        val name = editTextName.text.toString()
        val heightString = editTextHeight.text.toString()
        val weightString = editTextWeight.text.toString()
        val ageString = editTextAge.text.toString()

        if (name.isBlank() || heightString.isBlank() || weightString.isBlank() || ageString.isBlank()) {
            textViewResult.text = "Данные введены некорректно."
            textViewResult.visibility = View.VISIBLE
            return
        }

        val height = heightString.toDouble()
        val weight = weightString.toDouble()
        val age = ageString.toInt()

        if (height <= 0 || height >= 250 || weight <= 0 || weight >= 250 || age <= 0 || age >= 150) {
            textViewResult.text = "Данные введены некорректно."
            textViewResult.visibility = View.VISIBLE
            return
        }
        val result = calculateResult(height, weight, age)

        textViewResult.text = "Ответ: $result ккал"
        textViewResult.visibility = View.VISIBLE
    }

    private fun calculateResult(height: Double, weight: Double, age: Int): Double {
        // Формула Миффлина-Сан Жеора для вычисления БМС
        return  10 * weight + 6.25 * height - 5 * age + 5
    }
}