package com.punchy.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var calcButton: Button
    private lateinit var editHeight: TextInputEditText
    private lateinit var editWeight: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcButton = findViewById(R.id.calc_button)
        editHeight = findViewById(R.id.edit_height)
        editWeight = findViewById(R.id.edit_weight)
        calcButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val weightString = editWeight.text.toString()
            val heightString = editHeight.text.toString()
            if (weightString.isNotEmpty() && heightString.isNotEmpty()) {
                val pa = PersonAttributes(weightString.toFloat(), heightString.toFloat())
                intent.putExtra("personAttributes", pa)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Alguns campos não foram preenchidos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}