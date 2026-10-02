package pe.edu.upc.easyvet.features.cart.infrastructure.remote

data class AddCarItemResponseDto(
    val message: String,
    val productId: Int,
    val quantity: Int
)
