package pe.edu.upc.easyvet.features.home.infrastructure.repositories

import pe.edu.upc.easyvet.features.home.domain.Product
import pe.edu.upc.easyvet.features.home.domain.ProductRepository
import pe.edu.upc.easyvet.features.home.infrastructure.local.ProductDao
import pe.edu.upc.easyvet.features.home.infrastructure.local.ProductEntity
import pe.edu.upc.easyvet.features.home.infrastructure.remote.ProductService
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val service: ProductService,
    private val dao: ProductDao
) : ProductRepository {
    override suspend fun getProducts(): Result<List<Product>> {
        try {
            val response = service.getProducts()

            if (response.isSuccessful) {
                val entities = response.body()?.products?.map { dto ->
                    ProductEntity(
                        id = dto.id,
                        name = dto.title,
                        price = dto.price,
                        imageUrl = dto.image,
                        rating = dto.rating,
                        description = dto.description
                    )

                }?.toList()
                entities?.let { entities ->
                    dao.insertProducts(entities)
                }
            }
        } catch (_: Exception) {

        }
        val entities = dao.fetchAllProducts()
        val products = entities.map { entity ->
            Product(
                id = entity.id,
                name = entity.name,
                price = entity.price,
                imageUrl = entity.imageUrl,
                rating = entity.rating,
                description = entity.description
            )
        }.toList()
        return Result.success(products)
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