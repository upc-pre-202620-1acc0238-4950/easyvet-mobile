package pe.edu.upc.easyvet.features.cart.infrastructure.remote

data class AddCartItemRequestDto(
    val productId: Int,
    val quantity: Int
)
