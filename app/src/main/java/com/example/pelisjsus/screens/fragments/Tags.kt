package com.example.pelisjsus.screens.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pelisjsus.screens.NavScreen

@Composable
fun Tags(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        // .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Tag("Tag 1", Icons.Default.Home, Color(0XFFEF9A9A)) {
            navController.navigate(NavScreen.Home.route)
        }
        Tag("Tag 2", Icons.Default.Search, Color(0XFFEF9A9A)) {
            navController.navigate(NavScreen.MovieSearchScreen.route)
        }
    }
}

@Composable
fun Tag(text: String, icon: ImageVector, color: Color, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .width(80.dp)
            .height(40.dp)

    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(Color(0XFF212121))
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = color,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

