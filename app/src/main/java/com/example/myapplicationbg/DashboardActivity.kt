package com.example.myapplicationbg

import android.content.Intent
import android.widget.Button
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val categoryButton = findViewById<Button>(R.id.categoryButton)
        val expenseButton = findViewById<Button>(R.id.expenseButton)
        val goalButton = findViewById<Button>(R.id.goalButton)
        val viewExpensesButton = findViewById<Button>(R.id.viewExpensesButton)
        val categorySummaryButton = findViewById<Button>(R.id.categorySummaryButton)

        goalButton.setOnClickListener {
            startActivity(Intent(this, GoalActivity::class.java))
        }

        viewExpensesButton.setOnClickListener {
            startActivity(Intent(this, ExpenseListActivity::class.java))
        }

        categorySummaryButton.setOnClickListener {
            startActivity(Intent(this, CategorySummaryActivity::class.java))
        }

        categoryButton.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
        }

        expenseButton.setOnClickListener {
            val intent = Intent(this, ExpenseActivity::class.java)
            startActivity(intent)
        }
    }
}