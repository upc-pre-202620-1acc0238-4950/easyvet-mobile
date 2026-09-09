package pe.edu.upc.easyvet.features.home.presentation

import pe.edu.upc.easyvet.features.home.domain.Product

data class HomeUiState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

