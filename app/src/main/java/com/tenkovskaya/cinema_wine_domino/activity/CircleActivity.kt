package com.tenkovskaya.cinema_wine_domino.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tenkovskaya.cinema_wine_domino.R
import com.tenkovskaya.cinema_wine_domino.databinding.ActivityCircleBinding

class CircleActivity : AppCompatActivity() {

    lateinit var binding: ActivityCircleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCircleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        navigationViewActiv()
    }

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