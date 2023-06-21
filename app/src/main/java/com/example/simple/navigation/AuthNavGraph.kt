package com.example.simple.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navigation
import com.example.simple.screens.login.EnterDetailsScreen
import com.example.simple.screens.login.LoginScreen

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.authNavGraph(navController: NavController){
navigation(route=Graph.Authentication , startDestination = AuthScreens.LoginScreen.name){
    composable(
        AuthScreens.LoginScreen.name,
        enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Left , animationSpec = tween(700))},
        exitTransition = {slideOutOfContainer(AnimatedContentScope.SlideDirection.Right , animationSpec = tween(700))},
        popEnterTransition = {slideIntoContainer(AnimatedContentScope.SlideDirection.Right , animationSpec = tween(700))},
        popExitTransition = {slideOutOfContainer(AnimatedContentScope.SlideDirection.Left , animationSpec = tween(700))})
    {
        LoginScreen(navController = navController)
    }

    composable(
        AuthScreens.EnterDetailsScreen.name,
        enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(700)) },
        exitTransition = {slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(700))},
        popEnterTransition = {slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(700))},
        popExitTransition = {slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(700))}
    ) {
        EnterDetailsScreen(navController = navController)
    }
}
}
enum class AuthScreens{
    LoginScreen,
    EnterDetailsScreen;

    companion object{
        fun fromRoute(route : String?) : AuthScreens = when (route?.substringBefore("/")){
            LoginScreen.name        ->LoginScreen
            EnterDetailsScreen.name -> EnterDetailsScreen
            null                    -> LoginScreen
            else    ->throw IllegalArgumentException("Route $route is not Recognised")
        }
    }

}