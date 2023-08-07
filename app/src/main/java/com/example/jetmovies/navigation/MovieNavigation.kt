package com.example.jetmovies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetmovies.screens.details.DetailsScreen
import com.example.jetmovies.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name) {
        composable(route = MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(route = MovieScreens.DetailsScreen.name) {
            DetailsScreen(navController = navController)
        }
    }
}