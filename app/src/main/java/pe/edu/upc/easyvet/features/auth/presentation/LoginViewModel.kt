package pe.edu.upc.easyvet.features.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.edu.upc.easyvet.features.auth.application.LoginUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val signIn: LoginUseCase) : ViewModel() {

    private val _state = MutableStateFlow(LoginUiState())
    val state: StateFlow<LoginUiState> = _state.asStateFlow()

    fun onEmailChanged(email: String) {
        _state.update { currentState ->
            currentState.copy(email = email)
        }
    }

    fun onPasswordChange(password: String) {
        _state.update { currentState ->
            currentState.copy(password = password)
        }
    }

    fun togglePasswordVisibility() {
        _state.update { currentState ->
            currentState.copy(isHidden = !currentState.isHidden)
        }
    }

    fun login() {
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(isLoading = true)
            }
            signIn(_state.value.email, _state.value.password)
                .onSuccess { user ->
                    _state.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            user = user,
                            isAuthenticated = true
                        )
                    }
                }
                .onFailure { exception ->
                    _state.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            errorMessage = exception.message
                        )
                    }
                }

        }
    }

}