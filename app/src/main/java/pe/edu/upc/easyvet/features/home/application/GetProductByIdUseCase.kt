package pe.edu.upc.easyvet.features.home.application

import pe.edu.upc.easyvet.features.home.domain.ProductRepository
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(private val repository: ProductRepository) {

    suspend operator fun invoke(id: Int) = repository.getProductById(id)
}