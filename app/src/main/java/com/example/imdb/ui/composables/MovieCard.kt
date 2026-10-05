package com.example.imdb.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.imdb.models.Movie
import androidx.compose.ui.layout.ContentScale

@Composable
fun MovieCard(movie: Movie) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row (
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = "Poster of ${movie.title}",
                modifier = Modifier
                    .height(180.dp)
                    .aspectRatio(2f / 3f),
                contentScale = ContentScale.Fit
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "⭐ ${movie.vote_average}"
                )

                Text(
                    text = "Release: ${movie.release_date}"
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = movie.overview
                )
            }
        }
    }
}