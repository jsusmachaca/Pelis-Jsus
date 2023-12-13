package com.example.pelisjsus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pelisjsus.screens.Home
import com.example.pelisjsus.screens.MovieSearchScreen
import com.example.pelisjsus.screens.NavScreen
import com.example.pelisjsus.screens.fragments.AHeader
import com.example.pelisjsus.screens.fragments.Tags

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            envoltorio()
        }
    }
}

@Composable
fun envoltorio() {
    val navController = rememberNavController()

    Surface(color = MaterialTheme.colorScheme.background) {

    Column (
        Modifier
            .background(Color(0XFF000000))
            .border(
                4.dp,
                Brush.verticalGradient(
                    listOf(
                        Color(0XFF000000),
                        Color(0XFF000000),
                        Color(0XFF212121),
                        Color(0XFF424242),
                    )
                ),
                shape = ShapeDefaults.ExtraSmall
            ),
    ){
        AHeader()
        Tags(navController)


        NavHost(navController = navController, startDestination = NavScreen.Home.route) {
            composable(NavScreen.Home.route) { Home() }
            composable(NavScreen.MovieSearchScreen.route) { MovieSearchScreen() }
            // Agrega otras composiciones para pantallas adicionales según sea necesario
        }
    }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview1() {
    envoltorio()
}