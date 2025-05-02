package com.example.myapplicationbg

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CategorySummaryActivity : AppCompatActivity() {

    data class Expense(val date: String, val category: String, val amount: Double)

    private val expenseList = listOf(
        Expense("2024-05-01", "Food", 50.0),
        Expense("2024-05-02", "Transport", 30.0),
        Expense("2024-05-03", "Entertainment", 20.0),
        Expense("2024-05-04", "Food", 25.0),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_summary)

        val startDateInput = findViewById<EditText>(R.id.startDateInput)
        val endDateInput = findViewById<EditText>(R.id.endDateInput)
        val filterButton = findViewById<Button>(R.id.filterButton)
        val summaryListView = findViewById<ListView>(R.id.summaryListView)

        filterButton.setOnClickListener {
            val startDate = startDateInput.text.toString()
            val endDate = endDateInput.text.toString()

            val filtered = expenseList.filter {
                it.date >= startDate && it.date <= endDate
            }

            val categoryTotals = filtered.groupBy { it.category }
                .mapValues { entry -> entry.value.sumOf { it.amount } }

            val summaryDescriptions = categoryTotals.map { (category, total) ->
                "$category: \$${total}"
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, summaryDescriptions)
            summaryListView.adapter = adapter
        }
    }
}
