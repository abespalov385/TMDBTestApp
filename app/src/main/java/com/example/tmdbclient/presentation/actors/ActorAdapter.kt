package com.example.tmdbclient.presentation.actors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.Actor
import com.example.tmdbclient.databinding.ListItemBinding

class ActorAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private val actorList = ArrayList<Actor>()

    fun setList(actors: List<Actor>) {
        actorList.clear()
        actorList.addAll(actors)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(actorList[position])
    }

    override fun getItemCount(): Int = actorList.size
}

class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(actor: Actor) {
        binding.titleTextView.text = actor.name
        binding.descriptionTextView.text = actor.popularity.toString()
        val posterUrl = "https://image.tmdb.org/t/p/w500" + actor.profilePath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}