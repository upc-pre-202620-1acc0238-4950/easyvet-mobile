package pe.edu.upc.easyvet.features.cart.presentation.cart.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.easyvet.features.cart.domain.CartItem

@Composable
fun CartItemCard(cartItem: CartItem) {
    Card(modifier = Modifier.fillMaxWidth()) {

        Row {

            AsyncImage(
                model = cartItem.image,
                contentDescription = cartItem.name,
                modifier = Modifier.size(32.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = cartItem.name)
                Text(text = "Quantity: ${cartItem.quantity}")
                Text(text = "Price: ${cartItem.price}")
            }
        }
    }
}