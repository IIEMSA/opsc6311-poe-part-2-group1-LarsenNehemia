package com.example.myapplicationbg


import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_category)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val categoryNameInput = findViewById<EditText>(R.id.categoryNameInput)
        val saveCategoryButton = findViewById<Button>(R.id.saveCategoryButton)

        saveCategoryButton.setOnClickListener {
            val categoryName = categoryNameInput.text.toString()
            if(categoryName.isNotEmpty()){
                Toast.makeText(this, "Category '$categoryName' saved", Toast.LENGTH_SHORT).show()
                // TODO: Save to RoomDb Later
                categoryNameInput.text.clear()
            }else{
                Toast.makeText(this, "Please enter a category name", Toast.LENGTH_SHORT).show()
            }

        }
    }
}