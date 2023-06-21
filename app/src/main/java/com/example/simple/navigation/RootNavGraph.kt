package com.example.simple.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RootNavGraph(navController: NavHostController){
    AnimatedNavHost(navController = navController, route =Graph.Root , startDestination = Graph.Splash ){

    }

}
object Graph{
    const val Root = "root_graph"
    const val Introduction = "intro_graph"
    const val Authentication = "auth_graph"
    const val Home ="home_graph"
    const val Splash = "splash_graph"
}
sealed class RootNavGraph(val route : String){
    object MainScreen : RootNavGraph("main_screen")
}











//@OptIn(ExperimentalAnimationApi::class)
//@Composable
//fun RootNavGraph(navController: NavHostController) {
//AnimatedNavHost(navController = navController, route =Graph.Root, startDestination = Graph.Splash ){
//    splashAndPermission(navController=navController)
//      authNavGraph(navController = navController)
//    composable(route = Graph.Bottom){
//        MainScreen()
//    }
//}
//}
