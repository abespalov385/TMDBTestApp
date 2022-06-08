package com.example.tmdbclient.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityHomeBinding
import com.example.tmdbclient.presentation.actors.ActorsActivity
import com.example.tmdbclient.presentation.movie.MovieActivity
import com.example.tmdbclient.presentation.tvshow.TvShowsActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            val intent = Intent(this, TvShowsActivity::class.java)
            startActivity(intent)
        }

        binding.actorsButton.setOnClickListener {
            val intent = Intent(this, ActorsActivity::class.java)
            startActivity(intent)
        }
    }
}