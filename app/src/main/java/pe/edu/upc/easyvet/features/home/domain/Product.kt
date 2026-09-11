package pe.edu.upc.easyvet.features.home.domain

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val rating: Double,
    val imageUrl: String,
    val description: String
)