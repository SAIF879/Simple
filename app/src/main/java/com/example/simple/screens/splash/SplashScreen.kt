package com.example.simple.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.simple.ui.theme.PaleBlue
import com.example.simple.ui.theme.Sand

@Composable
fun SplashScreen(navController: NavController){

    SimpleApp {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))

            UpperPortion(modifier=Modifier.weight(1f)) {

            }
            LowePortion(modifier = Modifier.weight(1f)){

            }
        }
    }
    
}

@Composable
fun SimpleApp(content: @Composable () -> Unit) {
    Surface(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()

        )
        content.invoke()
    }
}

@Composable
fun UpperPortion(modifier: Modifier = Modifier , content : @Composable () -> Unit){
Box(modifier = Modifier.background(Color.Black).fillMaxHeight()){
    content.invoke()
}
}

@Composable
fun LowePortion(modifier: Modifier = Modifier , content: @Composable () -> Unit){
Box(modifier = Modifier.background(PaleBlue).fillMaxHeight()){
    content.invoke()
}
}
@Preview
@Composable
private fun getPrev(){
    SplashScreen(navController = NavController(LocalContext.current))
}