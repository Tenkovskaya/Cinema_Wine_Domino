package com.tenkovskaya.cinema_wine_domino.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.FirebaseApp
import com.tenkovskaya.cinema_wine_domino.Constant
import com.tenkovskaya.cinema_wine_domino.R
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.MovieAdapter
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.MovieDbService
import com.tenkovskaya.cinema_wine_domino.TheMovieDb.MovieResponse
import com.tenkovskaya.cinema_wine_domino.databinding.ActivityHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        navigationViewActiv()

        // Получаем список фильмов из API
//        getMoviesFromApi()

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



    private fun getMoviesFromApi() {
        val apiKey = Constant.API_KEY
        val language = "en-US"
        val page = 1

        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MovieDbService::class.java)
        val call = service.getPopularMovies(apiKey, language, page)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val movies = response.body()?.results
                    // Создаем и устанавливаем адаптер для RecyclerView
                    adapter = movies?.let { MovieAdapter(it) }!!
                    recyclerView.adapter = adapter
                } else {
                    Log.e("API_ERROR", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("API_ERROR", "Error: ${t.message}")
            }
        })
    }


}




