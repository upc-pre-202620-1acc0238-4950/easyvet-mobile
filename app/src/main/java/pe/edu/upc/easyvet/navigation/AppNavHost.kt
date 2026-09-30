package pe.edu.upc.easyvet.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import pe.edu.upc.easyvet.features.auth.presentation.navigation.AuthNavGraphRoute
import pe.edu.upc.easyvet.features.auth.presentation.navigation.authNavGraph
import pe.edu.upc.easyvet.features.home.presentation.navigation.homeNavGraph

@Composable
fun AppNavHost(navController: NavHostController) {

    Scaffold { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = AuthNavGraphRoute,
            modifier = Modifier.padding(paddingValues)
        ) {
            authNavGraph(navController)
            homeNavGraph(navController)
        }
    }

}