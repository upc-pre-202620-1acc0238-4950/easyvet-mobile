package pe.edu.upc.easyvet.features.home.infrastructure.repositories

import kotlinx.coroutines.delay
import pe.edu.upc.easyvet.features.home.domain.Product
import pe.edu.upc.easyvet.features.home.domain.ProductRepository
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

class InMemoryRepository @Inject constructor() : ProductRepository {

    private val products = listOf(
        Product(
            id = 1,
            name = "Royal Canin Maxi Puppy",
            price = 42.5,
            description = "Dry food for large breed puppies. Supports bone growth and digestive health.",
            imageUrl = "https://i.imgur.com/WkZEOU6.png",
            rating = 4.8,
        ),
        Product(
            id = 2,
            name = "Eukanuba Active Adult",
            price = 72.99,
            description = "Complete nutrition with high-quality proteins for active adult dogs.",
            imageUrl = "https://i.imgur.com/guSk1sh.png",
            rating = 4.7
        )
    )

    override suspend fun getProducts(): Result<List<Product>> {

        return runCatching {
            delay(3000.milliseconds)
            products
        }

    }

    override suspend fun getProductById(id: Int): Result<Product> {
        val product = products.find { it.id == id }

        product?.let { product ->
            return Result.success(product)
        }
        return Result.failure(Exception("Product not found"))

    }
}