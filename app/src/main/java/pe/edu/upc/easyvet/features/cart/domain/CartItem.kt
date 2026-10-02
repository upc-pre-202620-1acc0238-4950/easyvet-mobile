package pe.edu.upc.easyvet.features.cart.domain

class CartItem(
    val productId: Int,
    val name: String,
    val image: String,
    val price: Double,
    val quantity: Int,
    val category: String
)
