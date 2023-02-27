package com.tenkovskaya.cinema_wine_domino.TheMovieDb.TWShow

import com.google.gson.annotations.SerializedName

data class TVResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val tvShows: List<TVShow>,
    @SerializedName("total_pages") val pages: Int
)
