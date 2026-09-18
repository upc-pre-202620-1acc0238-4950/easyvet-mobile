package pe.edu.upc.easyvet.features.home.presentation.productdetail

import pe.edu.upc.easyvet.features.home.domain.Product

sealed class ProductDetailUiState {
    object Loading : ProductDetailUiState()
    data class Success(val product: Product) : ProductDetailUiState()
    data class Error(val message: String) : ProductDetailUiState()
}