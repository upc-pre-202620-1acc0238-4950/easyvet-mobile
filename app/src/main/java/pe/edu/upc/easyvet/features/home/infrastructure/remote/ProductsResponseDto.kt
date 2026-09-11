package pe.edu.upc.easyvet.features.home.infrastructure.remote

import com.google.gson.annotations.SerializedName

data class ProductsResponseDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("results")
    val products: List<ProductDto>
)
