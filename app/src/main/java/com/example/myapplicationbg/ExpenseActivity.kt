package com.example.myapplicationbg

import android.app.Activity
import android.widget.Toast
import android.content.Intent
import android.provider.MediaStore
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExpenseActivity : AppCompatActivity() {

    //COME BACK TO THIS!!!
    private val PICK_IMAGE_REQUEST = 1
    private var imageUri: Uri? = null
    private lateinit var expenseImageView: ImageView
   //COME BACK TO THIS!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_expense)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dateInput = findViewById<EditText>(R.id.dateInput)
        val startTimeInput = findViewById<EditText>(R.id.startTimeInput)
        val endTimeInput = findViewById<EditText>(R.id.endTimeInput)
        val descriptionInput = findViewById<EditText>(R.id.descriptionInput)
        val categoryInput = findViewById<EditText>(R.id.categoryInput)
        val saveExpenseButton = findViewById<Button>(R.id.saveExpenseButton)
        //COME BACK TO THIS!!
        val uploadPhotoButton = findViewById<Button>(R.id.uploadPhotoButton)
        expenseImageView = findViewById(R.id.expenseImageView)

        //COME BACK TO THIS!!
        uploadPhotoButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type ="image/*"
            startActivityForResult(intent,PICK_IMAGE_REQUEST)
        }

        saveExpenseButton.setOnClickListener {
            val date = dateInput.text.toString()
            val startTime = startTimeInput.text.toString()
            val endTime = endTimeInput.text.toString()
            val description = descriptionInput.text.toString()
            val category = categoryInput.text.toString()

           if(date.isNotEmpty() && startTime.isNotEmpty() && endTime.isNotEmpty() && description.isNotEmpty() && category.isNotEmpty()){
               Toast.makeText(this,"Expense saved",Toast.LENGTH_SHORT).show()
           }
           else{
               Toast.makeText(this,"Please fill in all fields",Toast.LENGTH_SHORT).show()
           }
        }
    }

    override fun onActivityResult(requestCode:Int,resultCode:Int,data:Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            imageUri = data.data
            expenseImageView.setImageURI(imageUri)
        }
    }

}

