package pe.edu.upc.easyvet.features.home.application

import pe.edu.upc.easyvet.features.home.domain.ProductRepository

class GetProductsUseCase(private val repository: ProductRepository) {
    operator fun invoke() = repository.getProducts()
}