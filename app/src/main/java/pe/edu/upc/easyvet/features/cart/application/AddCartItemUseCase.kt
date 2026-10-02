package pe.edu.upc.easyvet.features.cart.application

import pe.edu.upc.easyvet.features.cart.domain.CartRepository
import javax.inject.Inject

class AddCartItemUseCase @Inject constructor(private val repository: CartRepository) {

    suspend operator fun invoke(productId: Int, quantity: Int): Result<Unit> {
        return repository.addItemToCart(productId, quantity)
    }
}