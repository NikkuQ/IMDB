package com.example.imdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.imdb.ui.theme.IMDBTheme
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.imdb.models.Movie
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import com.example.imdb.api.RetrofitClient
import com.example.imdb.ui.composables.MovieCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IMDBTheme {
                MainMenu()
            }
        }
    }
}

@Composable
fun MainMenu() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Movie Browser",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            Button(
                onClick = {
                    // Lo implementiamo nel prossimo passaggio
                }
            ) {
                Text("Popular Movies")
            }

        }
    }
}

@PreviewScreenSizes
@Composable
fun IMDBApp() {
    var movies by remember {
        mutableStateOf<List<Movie>>(emptyList())
    }

    LaunchedEffect(Unit) {

        try {
            val response = RetrofitClient.api.getDiscoveryMovies()
            response.results.forEach { movie ->
                Log.d("TMDB", "ID: ${movie.id}," +
                        " Title: ${movie.title}, " +
                        "PosterPath: ${movie.poster_path}, " +
                        "Release: ${movie.release_date}, " +
                        "Vote: ${movie.vote_average}, " +
                        "Overview: ${movie.overview}")
            }
            movies = response.results
        } catch (e: Exception) {
            Log.e("TMDB", "Error: ${e.message}")
        }
    }
//    LazyColumn(
//        modifier = Modifier.padding(innerPadding)
//    ) {
//        items(movies) { movie ->
//            MovieCard(movie)
//        }
//    }
}

enum class AppDestinations(
    val label: String,
    val icon: Int,
) {
    HOME("Home", R.drawable.ic_home),
    FAVORITES("Favorites", R.drawable.ic_favorite),
    PROFILE("Profile", R.drawable.ic_account_box),
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IMDBTheme {
        Greeting("Android")
    }
}