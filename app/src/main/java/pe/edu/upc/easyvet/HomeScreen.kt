package pe.edu.upc.easyvet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.easyvet.ui.theme.EasyVetTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val products = listOf(
        Product(
            id = 1,
            name = "Royal Canin Maxi Puppy",
            price = 42.5,
            description = "Dry food for large breed puppies. Supports bone growth and digestive health.",
            imageUrl = "https://i.imgur.com/WkZEOU6.png",
            rating = 4.8,
        ),
        Product(
            id = 2,
            name = "Eukanuba Active Adult",
            price = 72.99,
            description = "Complete nutrition with high-quality proteins for active adult dogs.",
            imageUrl = "https://i.imgur.com/guSk1sh.png",
            rating = 4.7
        )
    )
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            Text(text = "Home Screen")
        }

        items(10) { index ->
            Text(text = "Item $index")
        }

        items(products) { product ->
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.45f)
                    .padding(8.dp)
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    AsyncImage(
                        model = product.imageUrl,
                        contentDescription = product.name,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(text = product.name, fontWeight = FontWeight.Bold, maxLines = 1)
                    Text(text = "${product.rating}")
                    Text(text = "$ ${product.price}", fontWeight = FontWeight.Bold)
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EasyVetTheme(dynamicColor = false) {
        HomeScreen()
    }
}