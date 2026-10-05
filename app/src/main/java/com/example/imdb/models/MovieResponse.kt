package com.example.imdb.models

data class MovieResponse(
    val page: Int,
    val results: List<Movie>
)