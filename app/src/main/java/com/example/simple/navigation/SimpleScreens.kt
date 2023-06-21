package com.example.simple.navigation

import java.lang.IllegalArgumentException

enum class SimpleScreens {
    IntroNotesScreen,
    IntroTodoScreen,
    LoginScreen,
    EnterDetailsScreen,
    HomeScreen,
    SplashScreen;

    companion object {

        fun fromRoute(route: String?): SimpleScreens = when (route?.substringBefore("/")) {
            IntroNotesScreen.name   -> IntroNotesScreen
            IntroTodoScreen.name    -> IntroTodoScreen
            LoginScreen.name        -> LoginScreen
            EnterDetailsScreen.name -> EnterDetailsScreen
            HomeScreen.name         -> HomeScreen
            SplashScreen.name       -> SplashScreen
            null                    -> LoginScreen
            else -> throw IllegalArgumentException("Route $route is not recognised")
        }
    }
}


