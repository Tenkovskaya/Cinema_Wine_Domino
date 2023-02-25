package com.tenkovskaya.cinema_wine_domino.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tenkovskaya.cinema_wine_domino.Constant.TAG
import com.tenkovskaya.cinema_wine_domino.R
import com.tenkovskaya.cinema_wine_domino.databinding.ActivityCircleBinding

class CircleActivity : AppCompatActivity() {

    lateinit var binding: ActivityCircleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCircleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationViewActiv()
        checkLogin()

    }

    private fun checkLogin() {
        val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val email = sharedPref.getString("login", "")
        val password = sharedPref.getString("password", "")
        val name = sharedPref.getString("name", "")

        if (!email.isNullOrEmpty() && !password.isNullOrEmpty() && !name.isNullOrEmpty()) {
            Log.d(TAG, "profile page checking" )
            val savedName= sharedPref.getString("name", "")
            binding.nameInformation.text = savedName
        } else {
            // Данных нет, переходим на страницу регистрации
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

//    fun usernameInfo(view:View){
//        val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
//        val savedName= sharedPref.getString("name", "")
//        binding.nameInformation.text = savedName
//    }

    fun navigationViewActiv() {
        binding.bottomNavigator.apply {
            selectedItemId = R.id.circle_page
            setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.home_page -> {
                        startActivity(Intent(applicationContext, HomeActivity::class.java))
                        finish()
                        overridePendingTransition(0, 0)
                        true
                    }
                    R.id.circle_page -> true
                    R.id.search_page -> {
                        startActivity(Intent(applicationContext, SearchActivity::class.java))
                        finish()
                        overridePendingTransition(0, 0)
                        true
                    }
                    else -> false
                }
            }
        }
    }

}