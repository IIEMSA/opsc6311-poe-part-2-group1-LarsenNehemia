package com.example.myapplicationbg

import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignupActivity : AppCompatActivity() {

    companion object {
        var registeredUsername = "user"
        var registeredPassword = "pass"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val signupUsername = findViewById<EditText>(R.id.signupUsername)
        val signupPassword = findViewById<EditText>(R.id.signupPassword)
        val signupButton = findViewById<Button>(R.id.signupSubmit)
        val backButton = findViewById<Button>(R.id.backToLogin)

        signupButton.setOnClickListener {
            registeredUsername= signupUsername.text.toString()
            registeredPassword = signupPassword.text.toString()
            Toast.makeText(this,"Sign up successful",Toast.LENGTH_SHORT).show()
        }
        backButton.setOnClickListener {
            finish()
        }
    }
}