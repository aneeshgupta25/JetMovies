package com.example.jetmovies.screens.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, movieData: String?) {
    Text(
       "Details Screen!!"
    )
    //navController.popBackStack() -> to go back to previous screen
}