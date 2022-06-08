package com.example.tmdbclient.data.repository.tvshow

import android.util.Log
import com.example.tmdbclient.data.model.TVShowList
import com.example.tmdbclient.data.model.TvShow
import com.example.tmdbclient.domain.repository.TvShowRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRepositoryImpl @Inject constructor(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource
) : TvShowRepository {

    override fun getTvShows(): Flow<List<TvShow>> = flow {
        emit(tvShowLocalDataSource.getTvShowsFromDB())
        updateTvShows()
        emitAll(tvShowLocalDataSource.getTvShowsFlowFromDB())
    }.flowOn(Dispatchers.IO)

    override suspend fun updateTvShows() {
        val newListOfTvShows = getTvShowsFromAPI()
        if (!newListOfTvShows.isNullOrEmpty()) {
            tvShowLocalDataSource.clearAll()
            tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        }
    }

    private suspend fun getTvShowsFromAPI(): List<TvShow> {
        var tvShowList: List<TvShow> = emptyList()
        withContext(Dispatchers.IO) {
            try {
                val response: Response<TVShowList> = tvShowRemoteDataSource.getTvShows()
                response.body()?.let {
                    tvShowList = it.results
                }
            } catch (exception: Exception) {
                Log.i("MyTag", exception.message.toString())

            }
        }
        return tvShowList
    }
}