package com.example.myapplicationbg

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ExpenseListActivity : AppCompatActivity() {

    // Fake expense data list
    data class Expense(val date: String, val description: String, val amount: Double, val imageUri: String?)

    private val expenseList = listOf(
        Expense("2024-05-01", "Groceries", 50.0, null),
        Expense("2024-05-02", "Fuel", 30.0, null),
        Expense("2024-05-03", "Movie", 20.0, null),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_list)

        val startDateInput = findViewById<EditText>(R.id.startDateInput)
        val endDateInput = findViewById<EditText>(R.id.endDateInput)
        val filterButton = findViewById<Button>(R.id.filterButton)
        val expenseListView = findViewById<ListView>(R.id.expenseListView)

        filterButton.setOnClickListener {
            val startDate = startDateInput.text.toString()
            val endDate = endDateInput.text.toString()

            // Simple date filter (just a fake logic for demo purpose)
            val filtered = expenseList.filter {
                it.date >= startDate && it.date <= endDate
            }

            val expenseDescriptions = filtered.map {
                "${it.date}: ${it.description} - \$${it.amount}"
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, expenseDescriptions)
            expenseListView.adapter = adapter

            // Optional: Show Toast when clicking an expense (simulate photo viewing)
            expenseListView.setOnItemClickListener { _, _, position, _ ->
                val selected = filtered[position]
                Toast.makeText(this, "Photo: ${selected.imageUri ?: "No photo"}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
