package com.tenkovskaya.cinema_wine_domino.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tenkovskaya.cinema_wine_domino.R
import com.tenkovskaya.cinema_wine_domino.databinding.ActivityHomeBinding
import com.tenkovskaya.cinema_wine_domino.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)


        navigationViewActiv()
    }

    fun navigationViewActiv() {
        binding.bottomNavigator.apply {
            selectedItemId = R.id.search_page
            setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.circle_page -> {
                        startActivity(Intent(applicationContext, CircleActivity::class.java))
                        finish()
                        overridePendingTransition(0, 0)
                        true
                    }
                    R.id.search_page -> true
                    R.id.home_page -> {
                        startActivity(Intent(applicationContext, HomeActivity::class.java))
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