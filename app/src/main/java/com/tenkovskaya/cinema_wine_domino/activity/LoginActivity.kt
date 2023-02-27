package com.tenkovskaya.cinema_wine_domino.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.tenkovskaya.cinema_wine_domino.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {


    private lateinit var name: EditText
    private lateinit var btnext: Button


    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnext = binding.buttonRegister
        name = binding.editName

        btnext.setOnClickListener {

            val sName = name.text.toString().trim()

            saveToSharedPref(sName)

            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveToSharedPref(name: String) {
        val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("name", name)
        editor.apply()
    }
}
