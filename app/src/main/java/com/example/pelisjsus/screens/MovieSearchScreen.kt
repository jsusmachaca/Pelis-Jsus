package com.example.pelisjsus.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.pelisjsus.models.MoviesItem
import com.example.pelisjsus.services.MovieSearchService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pelisjsus.repository.MovieSearchRepository


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieSearchScreen() {
    var searchQuery by remember { mutableStateOf("") }
    var movie by remember { mutableStateOf<MoviesItem?>(null) }
    val searchMovie = MovieSearchRepository()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFF000000))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier

                .fillMaxWidth()
                .height(47.dp)
                .background(Color(0XFF212121)),
            value = searchQuery,
            onValueChange = { searchQuery = it },

            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                    }
                } else {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text
            ),
        )

        movie?.let { MovieDetails(movie = it) }

        Button(
            onClick = {
                if (searchQuery.isNotEmpty()) {
                    try {
                        searchMovie.searchMovie(searchQuery) { result ->
                            movie = result
                        }
                    } catch(e: Exception) {
                        println("Error $e")
                    }

                }
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0XFF212121))
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color(0XFFEF9A9A),
                modifier = Modifier.size(30.dp)
            )
            Text(
                "Buscar",
                color = Color(0XFFEF9A9A)
            )
        }


    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun MovieDetails(movie: MoviesItem) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(data = movie.banner).apply(block = fun ImageRequest.Builder.() {
        }).build())

        Card (
            modifier = Modifier
                .width(350.dp)
                .height(460.dp)
                .padding(8.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0XFF424242)), // Establecer el color de fondo aquí
            ) {
                Column(
                    modifier = Modifier
                        .padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .width(300.dp)
                            .height(265.dp)
                            .padding(8.dp)
                            .clip(shape = MaterialTheme.shapes.small),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = movie.descripcion,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Director: ${movie.director}",
                        fontSize = 14.sp,
                        color = Color(0XFFEF9A9A)
                    )
                    Spacer(modifier = Modifier.height(13.dp))
                    Row {
                        repeat(movie.puntuacion.toInt()) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color.Yellow,
                                modifier = Modifier.size(25.dp)
                            )
                        }
                    }
                    when (movie.puntuacion) {
                        in Int.MIN_VALUE..3 -> Text(text = "Hay mejores opciones", color = Color.Gray)
                        in 4..6 -> Text(text = "Recomendada", color = Color.Gray)
                        in 7..8 -> Text(text = "Tienes que verla", color = Color.Gray)
                        10 -> Text(text = "Es la mejor película del mundo", color = Color.Gray)
                        else -> Text(text = "No la veas", color = Color.Gray)
                    }
                }
            }
        }
}


@Preview(showBackground = true)
@Composable
fun ver() {
    MovieSearchScreen()
}