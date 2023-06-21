package com.example.simple.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.simple.screens.home.HomeScreen
import com.google.accompanist.navigation.animation.composable
import java.lang.IllegalArgumentException

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(route = Graph.Home, startDestination = HomeScreens.HomeScreen.name) {
        composable(
            HomeScreens.HomeScreen.name,
            enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(700)) },
            exitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(700))},
            popEnterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(700))},
            popExitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(700))}) {
                HomeScreen(navController = navController)
        }
    }
}

enum class HomeScreens{
    HomeScreen;
    companion object{
        fun fromRoute(route: String?): HomeScreens = when (route?.substringBefore("/")) {
            HomeScreen.name   ->HomeScreen
            null              -> HomeScreen
            else-> throw IllegalArgumentException("Route $route not found")
        }
    }
}