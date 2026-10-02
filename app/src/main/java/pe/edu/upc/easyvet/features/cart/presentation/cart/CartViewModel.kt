package pe.edu.upc.easyvet.features.cart.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.edu.upc.easyvet.features.cart.application.GetCartUseCase
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val getCart: GetCartUseCase) : ViewModel() {

    private val _state = MutableStateFlow(CartUiState())
    val state: StateFlow<CartUiState> = _state.asStateFlow()

    init {
        loadCart()
    }

    fun loadCart() {
        viewModelScope.launch(Dispatchers.IO) {

            _state.update { currentState ->
                currentState.copy(
                    isLoading = true
                )
            }

            val result = getCart()
            result
                .onSuccess { cart ->
                    _state.update { currentState ->
                        currentState.copy(
                            cart = cart,
                            isLoading = false
                        )
                    }
                }
                .onFailure { exception ->
                    _state.update { currentState ->
                        currentState.copy(
                            errorMessage = exception.message,
                            isLoading = false
                        )
                    }
                }
        }

    }
}