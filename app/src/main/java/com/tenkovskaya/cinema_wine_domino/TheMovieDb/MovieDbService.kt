package com.tenkovskaya.cinema_wine_domino.TheMovieDb

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbService {
    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String, language: String, page: Int): Call<MovieResponse>
}