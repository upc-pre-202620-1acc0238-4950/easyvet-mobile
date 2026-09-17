package pe.edu.upc.easyvet.features.home.infrastructure.repositories

import pe.edu.upc.easyvet.features.home.domain.Product
import pe.edu.upc.easyvet.features.home.domain.ProductRepository
import pe.edu.upc.easyvet.features.home.infrastructure.remote.ProductService
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val service: ProductService
) : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        val response = service.getProducts()

        if (response.isSuccessful) {
            response.body()?.let { productsResponseDto ->
                return productsResponseDto.products.map { dto ->
                    Product(
                        id = dto.id,
                        name = dto.title,
                        price = dto.price,
                        imageUrl = dto.image,
                        rating = dto.rating,
                        description = dto.description
                    )

                }.toList()
            }
        }
        return emptyList()
    }

}