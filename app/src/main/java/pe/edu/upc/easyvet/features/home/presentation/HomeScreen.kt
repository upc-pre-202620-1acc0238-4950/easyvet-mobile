package pe.edu.upc.easyvet.features.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import pe.edu.upc.easyvet.features.home.domain.Product
import pe.edu.upc.easyvet.core.theme.EasyVetTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value


    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            Text(text = "Home Screen")
        }

        items(10) { index ->
            Text(text = "Item $index")
        }

        items(uiState.products) { product ->
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
    }
}