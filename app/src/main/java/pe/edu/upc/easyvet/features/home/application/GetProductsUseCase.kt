package pe.edu.upc.easyvet.features.home.application

import pe.edu.upc.easyvet.features.home.domain.ProductRepository
import pe.edu.upc.easyvet.features.home.infrastructure.repositories.ProductRepositoryImpl

class GetProductsUseCase(private val repository: ProductRepository = ProductRepositoryImpl()) {
    suspend operator fun invoke() = repository.getProducts()
}