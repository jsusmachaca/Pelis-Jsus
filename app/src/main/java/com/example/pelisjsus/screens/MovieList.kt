package com.example.pelisjsus.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.pelisjsus.models.Movies
import com.example.pelisjsus.models.MoviesItem
import com.example.pelisjsus.services.RetrofitInstance


@SuppressLint("MutableCollectionMutableState")
@Composable
fun MovieList() {
    var movies by remember { mutableStateOf<Movies?>(null) }
    LaunchedEffect(Unit) {
        try {
            val response = RetrofitInstance.movieService.getMovie()
            movies = response
        } catch (e: Exception) {
            println("Error $e")
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
            //.padding(16.dp)
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(items = movies ?: emptyList()) { index, movie ->
            MovieItem(movie, index)
        }
    }
}

@Composable
fun MovieItem(movie: MoviesItem, index: Int) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(data = movie.banner).apply(block = fun ImageRequest.Builder.() {
        }).build())
    Card (
        modifier = Modifier
            .width(350.dp)
            .height(295.dp)
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
                Text(
                    text = movie.titulo,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 19.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .width(300.dp)
                        .height(200.dp)
                        .padding(8.dp)
                        .clip(shape = MaterialTheme.shapes.small),
                    contentScale = ContentScale.Crop
                )
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
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview2() {
    MovieList()
}