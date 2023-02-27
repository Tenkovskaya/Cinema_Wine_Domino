package com.tenkovskaya.cinema_wine_domino.TheMovieDb.TWShow

import com.tenkovskaya.cinema_wine_domino.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiTVShow {
    @GET("tv/popular")
    fun getPopularTVShows(
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("page") page: Int
    ): Call<TVResponse>
}