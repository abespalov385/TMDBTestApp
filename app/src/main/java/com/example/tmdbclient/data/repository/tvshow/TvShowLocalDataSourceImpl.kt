package com.example.tmdbclient.data.repository.tvshow

import com.example.tmdbclient.data.db.TvShowsDao
import com.example.tmdbclient.data.model.TvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowLocalDataSourceImpl @Inject constructor(private val tvShowsDao: TvShowsDao): TvShowLocalDataSource {

    override suspend fun getTvShowsFromDB(): List<TvShow> = tvShowsDao.getTvShows()

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.saveTVShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.deleteAllTvShows()
        }
    }
}