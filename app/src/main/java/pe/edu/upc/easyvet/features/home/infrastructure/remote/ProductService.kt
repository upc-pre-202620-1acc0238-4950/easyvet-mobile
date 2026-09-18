package pe.edu.upc.easyvet.features.home.infrastructure.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    suspend fun getProducts(): Response<ProductsResponseDto>


    @GET("retrofit/{id}")
    suspend fun getProductById(@Path("id") id: Int): Response<ProductDto>
}