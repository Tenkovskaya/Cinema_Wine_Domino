package com.tenkovskaya.cinema_wine_domino.TheMovieDb

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<com.tenkovskaya.cinema_wine_domino.TheMovieDb.Movie>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)

