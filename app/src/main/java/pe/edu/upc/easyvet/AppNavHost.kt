package pe.edu.upc.easyvet

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import pe.edu.upc.easyvet.features.home.presentation.navigation.homeNavGraph

@Composable
fun AppNavHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home"){
        homeNavGraph(navController)
    }
}