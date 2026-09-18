package pe.edu.upc.easyvet.features.home.domain

interface ProductRepository {
    suspend fun getProducts(): Result<List<Product>>

    suspend fun getProductById(id: Int): Result<Product>
}