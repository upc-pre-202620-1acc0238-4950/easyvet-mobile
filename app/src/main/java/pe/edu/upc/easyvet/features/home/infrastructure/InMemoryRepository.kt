package pe.edu.upc.easyvet.features.home.infrastructure

import pe.edu.upc.easyvet.features.home.domain.Product
import pe.edu.upc.easyvet.features.home.domain.ProductRepository

class InMemoryRepository: ProductRepository {

    private val products =  listOf(
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
    override fun getProducts(): List<Product> {
        return products
    }
}