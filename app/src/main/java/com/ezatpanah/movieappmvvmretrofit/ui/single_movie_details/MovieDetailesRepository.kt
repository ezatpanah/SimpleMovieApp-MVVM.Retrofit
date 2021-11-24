package com.ezatpanah.movieappmvvmretrofit.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.ezatpanah.movieappmvvmretrofit.data.api.MovieDBInterface
import com.ezatpanah.movieappmvvmretrofit.data.model.MovieDetails
import com.ezatpanah.movieappmvvmretrofit.data.repository.MovieDetailsNetworkDataSource
import com.ezatpanah.movieappmvvmretrofit.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class MovieDetailesRepository(private val apiService: MovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource
    fun fetchSingleMovieDetails(
        compositeDisposable: CompositeDisposable,
        movieId: Int
    ): LiveData<MovieDetails> {

        movieDetailsNetworkDataSource =
            MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse
    }

    fun getMovieDetailsNetworkState():LiveData<NetworkState>{
        return movieDetailsNetworkDataSource.networkState
    }

}