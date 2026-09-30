package pe.edu.upc.easyvet.features.auth.presentation

import pe.edu.upc.easyvet.features.auth.domain.User

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isHidden: Boolean = true,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isAuthenticated: Boolean = false,
    val user: User? = null
)
