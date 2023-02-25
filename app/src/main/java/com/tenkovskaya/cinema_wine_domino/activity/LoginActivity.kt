package com.tenkovskaya.cinema_wine_domino.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.tenkovskaya.cinema_wine_domino.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var name: EditText
    private lateinit var btnext: Button

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        email = binding.editEmail
        password = binding.editPassword
        btnext = binding.buttonRegister
        name = binding.editName

        btnext.setOnClickListener {
            val sEmail = email.text.toString().trim()
            val sPassword = password.text.toString().trim()
            val sName = name.text.toString().trim()

            saveToSharedPref(sEmail, sPassword, sName)

            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveToSharedPref(email: String, password: String, name: String) {
        val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("login", email)
        editor.putString("password", password)
        editor.putString("name", name)
        editor.apply()
    }
}
