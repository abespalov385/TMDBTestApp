package com.example.tmdbclient.presentation.tvshow

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityTvShowsBinding
import com.example.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class TvShowsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter
    lateinit var binding: ActivityTvShowsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_shows)
        (application as Injector).createTvShowSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvShowRecyclerView.adapter = adapter
        binding.swipeRefresh.setOnRefreshListener {
            updateTvShows()
            binding.swipeRefresh.isRefreshing = false
        }
        displayPopularTvShows()
    }

    private fun displayPopularTvShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        updateTvShows()
        val responseLiveData = tvShowViewModel.allTvShows
        responseLiveData.observe(this) {
            if (!it.isNullOrEmpty()) {
                Log.d("MyTag", it.toString())
                adapter.submitList(it)
                binding.tvShowProgressBar.visibility = View.GONE
            }
        }
    }

    private fun updateTvShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        tvShowViewModel.updateTvShows()
    }
}