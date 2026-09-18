package pe.edu.upc.easyvet.features.home.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import pe.edu.upc.easyvet.core.theme.EasyVetTheme
import pe.edu.upc.easyvet.features.home.domain.Product
import pe.edu.upc.easyvet.features.home.presentation.home.components.ProductCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onProductClick: (Product) -> Unit
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value


    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when {
            uiState.products.isNotEmpty() -> {
                LazyColumn(modifier = modifier.fillMaxSize()) {
                    items(uiState.products) { product ->
                        ProductCard(product = product) {
                            onProductClick(product)
                        }
                    }
                }
            }

            uiState.isLoading -> {
                CircularProgressIndicator()
            }

            else -> {
                Text(text = uiState.errorMessage ?: "No products available")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EasyVetTheme(dynamicColor = false) {
        HomeScreen {}
    }
}