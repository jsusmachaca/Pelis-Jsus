package com.example.pelisjsus.screens

sealed class NavScreen(val route: String) {
    object Home : NavScreen("home")
    object MovieSearchScreen : NavScreen("movieSearch")
}