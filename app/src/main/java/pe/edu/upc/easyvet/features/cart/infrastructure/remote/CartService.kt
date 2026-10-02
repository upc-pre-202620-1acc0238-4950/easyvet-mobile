package pe.edu.upc.easyvet.features.cart.infrastructure.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CartService {

    @GET("cart")
    suspend fun getCart(): Response<CartDto>


    @POST("cart")
    suspend fun addItemToCart(@Body requestDto: AddCartItemRequestDto): Response<AddCarItemResponseDto>
}