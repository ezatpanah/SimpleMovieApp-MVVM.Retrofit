package com.ezatpanah.movieappmvvmretrofit.ui.single_movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ezatpanah.movieappmvvmretrofit.data.model.MovieDetails
import com.ezatpanah.movieappmvvmretrofit.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel(private val movieRepository :MovieDetailesRepository,movieId:Int): ViewModel(){

    private val compositeDisposable =CompositeDisposable()

    val movieDetails :LiveData<MovieDetails>by lazy{
        movieRepository.fetchSingleMovieDetails(compositeDisposable,movieId)
    }

    val networkState :LiveData<NetworkState>by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()

    }
}