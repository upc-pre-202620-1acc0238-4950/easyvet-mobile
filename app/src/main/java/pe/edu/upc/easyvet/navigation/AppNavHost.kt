package pe.edu.upc.easyvet.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import pe.edu.upc.easyvet.features.home.presentation.navigation.HomeRoute
import pe.edu.upc.easyvet.features.home.presentation.navigation.homeNavGraph

@Composable
fun AppNavHost(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            NavigationBar { }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = HomeRoute,
            modifier = Modifier.padding(paddingValues)
        ) {
            homeNavGraph(navController)
        }
    }

}