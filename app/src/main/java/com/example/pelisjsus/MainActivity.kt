package com.example.pelisjsus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pelisjsus.screens.Home
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
    Column (
        Modifier
            .background(Color(0XFF000000))
            .border(
                5.dp,
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
        Tags()
        Spacer(modifier = Modifier.width(16.dp))
        Home()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview1() {
    envoltorio()
}