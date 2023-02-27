package com.tenkovskaya.cinema_wine_domino.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tenkovskaya.cinema_wine_domino.R
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.TWShow.TVShow
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.TWShow.TVShowAdapter
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.TWShow.TvShowRepository
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.movie.Movie
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.movie.MovieAdapter
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.movie.MoviesRepository
import com.tenkovskaya.cinema_wine_domino.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var recyclerView: RecyclerView

    lateinit var popularMoviesAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationViewActiv()

        getPopularMovies()

    }


    private fun getPopularMovies(){
        recyclerView = binding.popularMovies // Получить ссылку на RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        popularMoviesAdapter = MovieAdapter(listOf())
        recyclerView.adapter = popularMoviesAdapter

        MoviesRepository.getPopularMoviesList(
            onSuccess = ::onPopularMoviesFetched,
            onError = ::onError
        )
    }


    private fun onPopularMoviesFetched(movies: List<Movie>) {
        Log.d("MainActivity", "Movies: $movies")
        popularMoviesAdapter.setMovies(movies)
        popularMoviesAdapter.updateMovies()
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




