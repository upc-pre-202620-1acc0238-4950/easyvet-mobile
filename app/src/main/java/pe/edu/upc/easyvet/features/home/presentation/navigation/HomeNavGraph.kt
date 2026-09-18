package pe.edu.upc.easyvet.features.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pe.edu.upc.easyvet.features.home.presentation.home.HomeScreen


fun NavGraphBuilder.homeNavGraph(navController: NavController) {

    composable("home") {
        HomeScreen()
    }

    composable ("product_detail"){

    }

}