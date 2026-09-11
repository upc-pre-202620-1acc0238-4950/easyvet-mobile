package pe.edu.upc.easyvet.features.home.infrastructure.remote

data class ProductsResponseDto(
    val count: Int,
    val products: List<ProductDto>
)
