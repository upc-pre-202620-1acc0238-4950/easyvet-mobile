package pe.edu.upc.easyvet.features.cart.presentation.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import pe.edu.upc.easyvet.features.cart.presentation.cart.components.CartItemList

@Composable
fun CartScreen(modifier: Modifier = Modifier, viewModel: CartViewModel = hiltViewModel()) {

    val state = viewModel.state.collectAsStateWithLifecycle().value

    Column(modifier = modifier.fillMaxSize()) {

        when {
            state.cart.cartItems.isNotEmpty() -> {
                CartItemList(cartItems = state.cart.cartItems)
            }

            state.isLoading -> {
                CircularProgressIndicator()
            }

            state.errorMessage != null -> {
                Text(text = state.errorMessage)
            }

            else -> {
                Text(text = "Your cart is empty")
            }
        }
    }

}