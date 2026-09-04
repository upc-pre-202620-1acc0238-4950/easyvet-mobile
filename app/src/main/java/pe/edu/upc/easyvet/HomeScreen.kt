package pe.edu.upc.easyvet

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.easyvet.ui.theme.EasyVetTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val products = listOf(
        "Product 1",
        "Product 2",
        "Product 3",
        "Product 4",
        "Product 5"
    )
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            Text(text = "Home Screen")
        }

        items(10) { index ->
            Text(text = "Item $index")
        }

        items(products) { product ->
            Card {
                Text(text = product)
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