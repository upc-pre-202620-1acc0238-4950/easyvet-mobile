package pe.edu.upc.easyvet.features.home.application

import pe.edu.upc.easyvet.features.home.domain.ProductRepository
import pe.edu.upc.easyvet.features.home.infrastructure.InMemoryRepository

class GetProductsUseCase(private val repository: ProductRepository = InMemoryRepository()) {
    suspend operator fun invoke() = repository.getProducts()
}