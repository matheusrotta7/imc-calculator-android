package com.punchy.imccalculator

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var heightText: TextView
    private lateinit var weightText: TextView
    private lateinit var diagnosisText: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        heightText = findViewById(R.id.height_text)
        weightText = findViewById(R.id.weight_text)
        diagnosisText = findViewById(R.id.diagnosis_text)
        backButton = findViewById(R.id.backButton)

        val bundle = intent.extras
        val personAttributes = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle?.getParcelable("personAttributes", PersonAttributes::class.java)
        } else {
            bundle?.getParcelable("personAttributes")
        }

        heightText.text = "Peso informado: ${personAttributes?.height.toString()} m"
        weightText.text = "Altura informada: ${personAttributes?.weight.toString()} kg"

        val imc = calculateIMC(personAttributes?.height, personAttributes?.weight)
        val imcClassification = IMCClass.givenValueReturnClassification(imc).portugueseText
        val imcValueString = "%.2f".format(imc)
        diagnosisText.text = "$imcClassification ($imcValueString)"

        backButton.setOnClickListener {
            finish()
        }



    }

    private fun calculateIMC(height: Float?, weight: Float?): Float {
        return if (height != null && weight != null) {
            weight / (height * height)
        } else {
            0f
        }
    }
}