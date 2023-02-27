package com.tenkovskaya.cinema_wine_domino.TheMovieDb.movie

import com.tenkovskaya.cinema_wine_domino.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


    interface ApiMovie {

        @GET("movie/popular")
        fun getPopularMovies(
            @Query("api_key") apiKey: String = Constant.API_KEY,
            @Query("page") page: Int
        ): Call<MovieResponse>
    }