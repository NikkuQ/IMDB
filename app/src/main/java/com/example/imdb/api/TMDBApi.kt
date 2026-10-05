package com.example.imdb.api

import com.example.imdb.models.MovieResponse
import retrofit2.http.GET

interface TMDBApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(): MovieResponse

    @GET("discover/movie")
    suspend fun getDiscoveryMovies(): MovieResponse
}