package com.example.tmdbclient.presentation.actors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityActorsBinding
import com.example.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class ActorsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ActorViewModelFactory
    private lateinit var actorViewModel: ActorViewModel
    private lateinit var adapter: ActorAdapter
    lateinit var binding: ActivityActorsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_actors)
        (application as Injector).createActorSubComponent().inject(this)
        actorViewModel = ViewModelProvider(this, factory)[ActorViewModel::class.java]
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.actorRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ActorAdapter()
        binding.actorRecyclerView.adapter = adapter
        binding.swipeRefresh.setOnRefreshListener {
            updateMovies()
            binding.swipeRefresh.isRefreshing = false
        }
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.actorProgressBar.visibility = View.VISIBLE
        val responseLiveData = actorViewModel.getActors()
        responseLiveData.observe(this) {
            if (!it.isNullOrEmpty()) {
                adapter.setList(it)
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
            binding.actorProgressBar.visibility = View.GONE
        }
    }

    private fun updateMovies() {
        binding.actorProgressBar.visibility = View.VISIBLE
        val response = actorViewModel.updateActors()
        response.observe(this) {
            if (!it.isNullOrEmpty()) {
                adapter.setList(it)
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
            binding.actorProgressBar.visibility = View.GONE
        }
    }
}