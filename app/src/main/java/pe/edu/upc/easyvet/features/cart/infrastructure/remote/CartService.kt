package pe.edu.upc.easyvet.features.cart.infrastructure.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CartService {

    @GET("cart")
    suspend fun getCart(): Response<CartDto>


    @POST("cart")
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2OTFhYWUxNjE1Y2IxNmM0OTE3MGFmZjciLCJpYXQiOjE3OTA5NTQ2ODgsImV4cCI6MTc5MTA0MTA4OH0.wmmRKaLDSS4D5_LFLEhVoTNiWmSLXgh8bk-DU2Drl6w")
    suspend fun addItemToCart(@Body requestDto: AddCartItemRequestDto): Response<AddCarItemResponseDto>
}