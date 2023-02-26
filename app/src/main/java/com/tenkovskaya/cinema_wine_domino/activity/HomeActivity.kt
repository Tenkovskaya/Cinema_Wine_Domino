package com.tenkovskaya.cinema_wine_domino.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tenkovskaya.cinema_wine_domino.R
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.Movie
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.MovieAdapter
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.MoviesRepository
import com.tenkovskaya.cinema_wine_domino.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var popularMovies: RecyclerView

    lateinit var popularMoviesAdapter: MovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationViewActiv()

        popularMoviesline1()

    }


    fun popularMoviesline1(){
        popularMovies = binding.popularMovies // Получить ссылку на RecyclerView
        popularMovies.setHasFixedSize(true)
        popularMovies.layoutManager = GridLayoutManager(this, 3)
        popularMovies.adapter = MovieAdapter(listOf())

        popularMoviesAdapter = MovieAdapter(listOf())
        popularMovies.adapter = popularMoviesAdapter

        MoviesRepository.getPopularMoviesList(
            onSuccess = ::onPopularMoviesFetchedLine1,
            onError = ::onError
        )
    }


    private fun onPopularMoviesFetchedLine1(movies: List<Movie>) {
        Log.d("MainActivity", "Movies: $movies")
        popularMoviesAdapter.updateMovies(movies)
    }

    private fun onError() {
        Toast.makeText(this, getString(R.string.error_fetch_movies), Toast.LENGTH_SHORT).show()
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




