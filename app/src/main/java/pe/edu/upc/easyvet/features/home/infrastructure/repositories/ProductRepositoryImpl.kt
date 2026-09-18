package pe.edu.upc.easyvet.features.home.infrastructure.repositories

import pe.edu.upc.easyvet.features.home.domain.Product
import pe.edu.upc.easyvet.features.home.domain.ProductRepository
import pe.edu.upc.easyvet.features.home.infrastructure.remote.ProductService
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val service: ProductService
) : ProductRepository {
    override suspend fun getProducts(): Result<List<Product>> {
        val response = service.getProducts()

        if (response.isSuccessful) {
            val products = response.body()?.products?.map { dto ->
                Product(
                    id = dto.id,
                    name = dto.title,
                    price = dto.price,
                    imageUrl = dto.image,
                    rating = dto.rating,
                    description = dto.description
                )

            }?.toList()
            products?.let { products ->
                return Result.success(products)
            }
            return Result.failure(Exception("No products found."))
        }
        return Result.failure(Exception("No response"))
    }

    override suspend fun getProductById(id: Int): Result<Product> {

        val response = service.getProductById(id)

        if (response.isSuccessful) {
            val product = response.body()?.let { dto ->
                Product(
                    id = dto.id,
                    name = dto.title,
                    price = dto.price,
                    imageUrl = dto.image,
                    rating = dto.rating,
                    description = dto.description
                )
            }

            product?.let { product ->
                return Result.success(product)
            }
            return Result.failure(Exception("No product found."))
        }
        return Result.failure(Exception("No response"))

    }

}