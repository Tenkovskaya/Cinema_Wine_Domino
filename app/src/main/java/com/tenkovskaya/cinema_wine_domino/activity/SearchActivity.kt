package com.tenkovskaya.cinema_wine_domino.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.tenkovskaya.cinema_wine_domino.Constant.TAG
import com.tenkovskaya.cinema_wine_domino.R
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.Movie
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.MovieAdapter
import com.tenkovskaya.cinema_wine_domino.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigationView()



        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               // Log.d(TAG, "$newText" )
                filterMovies("", listOf())
                return true
            }
        })
    }

    fun filterMovies(searchText: String?, movies: List<Movie>){
        movieAdapter.updateMovies(movies)
        Log.d(TAG, "Movies: $movies")

    }


    private fun setupNavigationView() {
        binding.bottomNavigator.apply {
            selectedItemId = R.id.search_page
            setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.home_page -> {
                        startActivity(Intent(applicationContext, HomeActivity::class.java))
                        finish()
                        overridePendingTransition(0, 0)
                        true
                    }
                    R.id.circle_page -> {
                        startActivity(Intent(applicationContext, CircleActivity::class.java))
                        finish()
                        overridePendingTransition(0, 0)
                        true
                    }
                    R.id.search_page -> true
                    else -> false
                }
            }
        }
    }
}

