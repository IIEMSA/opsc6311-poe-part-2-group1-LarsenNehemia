package com.example.myapplicationbg

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GoalActivity : AppCompatActivity() {

    companion object {
        var minGoal = 0.0
        var maxGoal = 0.0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal)

        val minGoalInput = findViewById<EditText>(R.id.minGoalInput)
        val maxGoalInput = findViewById<EditText>(R.id.maxGoalInput)
        val saveGoalButton = findViewById<Button>(R.id.saveGoalButton)

        saveGoalButton.setOnClickListener {
            val minText = minGoalInput.text.toString()
            val maxText = maxGoalInput.text.toString()

            if (minText.isNotEmpty() && maxText.isNotEmpty()) {
                minGoal = minText.toDouble()
                maxGoal = maxText.toDouble()
                Toast.makeText(this, "Goals saved!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please fill both fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
