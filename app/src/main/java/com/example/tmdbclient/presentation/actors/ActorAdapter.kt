package com.example.tmdbclient.presentation.actors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.Actor
import com.example.tmdbclient.databinding.ListItemBinding

class ActorAdapter : ListAdapter<Actor, MyViewHolder>(ActorsDiffCallback) {

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
    fun bind(actor: Actor) {
        binding.titleTextView.text = actor.name
        binding.descriptionTextView.text = actor.popularity.toString()
        val posterUrl = "https://image.tmdb.org/t/p/w500" + actor.profilePath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}

object ActorsDiffCallback : DiffUtil.ItemCallback<Actor>() {
    override fun areItemsTheSame(oldItem: Actor, newItem: Actor): Boolean {
        return oldItem == newItem

    }

    override fun areContentsTheSame(oldItem: Actor, newItem: Actor): Boolean {
        return oldItem.id == newItem.id
                && oldItem.name == newItem.name
                && oldItem.popularity == newItem.popularity
                && oldItem.profilePath == newItem.profilePath
    }
}