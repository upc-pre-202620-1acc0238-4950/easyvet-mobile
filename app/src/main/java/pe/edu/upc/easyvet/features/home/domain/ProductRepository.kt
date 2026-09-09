package pe.edu.upc.easyvet.features.home.domain

interface ProductRepository {
    fun getProducts(): List<Product>
}