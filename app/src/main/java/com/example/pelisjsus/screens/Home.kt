package com.example.pelisjsus.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun Home() {
    Column (
        Modifier
            .fillMaxSize()
            .background(Color(0XFF000000)),
        // .background(Color(0XFF212121)),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        MovieList()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview1() {
    Home()
}