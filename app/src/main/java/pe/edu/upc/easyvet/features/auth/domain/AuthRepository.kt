package pe.edu.upc.easyvet.features.auth.domain

import pe.edu.upc.easyvet.features.auth.infrastructure.remote.AuthService

interface AuthRepository {

    suspend fun login(email: String, password: String): Result<User>
}