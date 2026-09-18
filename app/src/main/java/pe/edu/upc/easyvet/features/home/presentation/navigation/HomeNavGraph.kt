package pe.edu.upc.easyvet.features.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import pe.edu.upc.easyvet.features.home.presentation.home.HomeScreen


@Serializable
object HomeRoute

@Serializable
data class ProductDetailRoute(val id: Int)

fun NavGraphBuilder.homeNavGraph(navController: NavController) {

    composable<HomeRoute> {
        HomeScreen()
    }

    composable<ProductDetailRoute> {

    }

}