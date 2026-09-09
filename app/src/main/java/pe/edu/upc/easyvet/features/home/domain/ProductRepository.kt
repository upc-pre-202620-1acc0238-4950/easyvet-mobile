package pe.edu.upc.easyvet.features.home.domain

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}