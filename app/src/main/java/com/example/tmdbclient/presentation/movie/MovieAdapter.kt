package com.example.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.Movie
import com.example.tmdbclient.databinding.ListItemBinding

class MovieAdapter : ListAdapter<Movie, MyViewHolder>(MoviesDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        binding.titleTextView.text = movie.title
        binding.descriptionTextView.text = movie.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}

object MoviesDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem

    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
                && oldItem.overview == newItem.overview
                && oldItem.posterPath == newItem.posterPath
                && oldItem.releaseDate == newItem.releaseDate
                && oldItem.title == newItem.title
    }
}