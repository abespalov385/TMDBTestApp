package com.example.tmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.TvShow
import com.example.tmdbclient.databinding.ListItemBinding

class TvShowAdapter : ListAdapter<TvShow, MyViewHolder>(TvShowsDiffCallback) {

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
    fun bind(tvShow: TvShow) {
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)

    }
}

object TvShowsDiffCallback : DiffUtil.ItemCallback<TvShow>() {
    override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
        return oldItem == newItem

    }

    override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
        return oldItem.id == newItem.id
                && oldItem.name == newItem.name
                && oldItem.firstAirDate == newItem.firstAirDate
                && oldItem.overview == newItem.overview
                && oldItem.posterPath == newItem.posterPath
    }
}