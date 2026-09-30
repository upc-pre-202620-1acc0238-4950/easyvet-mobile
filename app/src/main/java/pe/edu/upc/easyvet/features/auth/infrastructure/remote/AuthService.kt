package pe.edu.upc.easyvet.features.auth.infrastructure.remote

import retrofit2.Response
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthService {

    @POST("users/login")
    @Headers("Content-Type: application/json")
    suspend fun login(email: String, password: String): Response<LoginResponseDto>
}