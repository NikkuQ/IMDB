package com.example.imdb.models

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val vote_average: Double,
    val release_date: String,
    val poster_path: String?
){
    val posterUrl: String?
        get() =  poster_path?.let {
            "https://image.tmdb.org/t/p/w500$it"
        }
}