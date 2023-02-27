package com.tenkovskaya.cinema_wine_domino.TheMovieDb.TWShow

import com.tenkovskaya.cinema_wine_domino.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TvShowRepository {
    val apiTvSeries: ApiTVShow

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiTvSeries = retrofit.create(ApiTVShow::class.java)
    }

    fun getPopularTvSeriesList(
        page: Int = 1,
        onSuccess: (tvSeries: List<TVShow>) -> Unit,
        onError: () -> Unit
    ) {

        apiTvSeries.getPopularTVShows(page = page)
            .enqueue(object : Callback<TVResponse> {
                override fun onResponse(
                    call: Call<TVResponse>,
                    response: Response<TVResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.tvShows)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<TVResponse>, t: Throwable) {
                    onError.invoke()
                }
            })

    }
}