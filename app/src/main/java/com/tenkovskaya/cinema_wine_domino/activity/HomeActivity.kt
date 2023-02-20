package com.tenkovskaya.cinema_wine_domino.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tenkovskaya.cinema_wine_domino.R
import com.tenkovskaya.cinema_wine_domino.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationViewActiv()
    }

    fun navigationViewActiv() {
        binding.bottomNavigator.apply {
            selectedItemId = R.id.home_page
            setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.circle_page -> {
                        startActivity(Intent(applicationContext, CircleActivity::class.java))
                        finish()
                        overridePendingTransition(0, 0)
                        true
                    }
                    R.id.home_page -> true
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


