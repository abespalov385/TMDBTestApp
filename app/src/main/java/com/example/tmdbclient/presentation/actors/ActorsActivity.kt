package com.example.tmdbclient.presentation.actors

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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
            updateActors()
            binding.swipeRefresh.isRefreshing = false
        }
        displayPopularActors()
    }

    private fun displayPopularActors() {
        binding.actorProgressBar.visibility = View.VISIBLE
        updateActors()
        val responseLiveData = actorViewModel.allActors
        responseLiveData.observe(this) {
            if (!it.isNullOrEmpty()) {
                Log.d("MyTag", it.toString())
                adapter.submitList(it)
                binding.actorProgressBar.visibility = View.GONE
            }
        }
    }

    private fun updateActors() {
        binding.actorProgressBar.visibility = View.VISIBLE
        actorViewModel.updateActors()
    }
}