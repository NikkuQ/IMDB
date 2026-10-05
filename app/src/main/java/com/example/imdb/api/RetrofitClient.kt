package com.example.imdb.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private const val TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlNjFlZjExZTNlZDhkNjMxN2JkYWRhZTBhNmY4Y2E1MiIsIm5iZiI6MTcxODgwODM5Ni4wNjIsInN1YiI6IjY2NzJlZjRjZTgzMzJjMjBmNjA1YzI1OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.eGYAusBduK4S15kieSQ5R4oq5_f-BjPhb2N8xQ3nuB8"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->

            val request = chain.request()
                .newBuilder()
                .addHeader(
                    "Authorization",
                    "Bearer $TOKEN"
                )
                .build()

            chain.proceed(request)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: TMDBApi = retrofit.create(TMDBApi::class.java)
}