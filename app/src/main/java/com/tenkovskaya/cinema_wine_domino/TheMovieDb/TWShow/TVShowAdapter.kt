package com.tenkovskaya.cinema_wine_domino.TheMovieDb.TWShow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.tenkovskaya.cinema_wine_domino.R

class TVShowAdapter(private var tvShows: List<TVShow>) : RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_tv_show, parent, false)
        return TVShowViewHolder(view)
    }

    override fun getItemCount(): Int = tvShows.size

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }

    fun setTVShows(tvShows: List<TVShow>) {
        this.tvShows = tvShows
    }


    fun getTVShows(): List<TVShow> {
        return this.tvShows
    }

    fun updateTVShows() {
        notifyDataSetChanged()
    }



    inner class TVShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val poster: ImageView = itemView.findViewById(R.id.tv_show_poster)
        private val name: TextView = itemView.findViewById(R.id.tv_show_title)

        fun bind(tvShow: TVShow) {
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${tvShow.posterPath}")
                .transform(CenterCrop())
                .into(poster)
            name.text = tvShow.name
        }
    }
}