package pe.edu.upc.easyvet.features.home.presentation.productdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import pe.edu.upc.easyvet.core.designsystem.icon.arrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    id: Int,
    modifier: Modifier = Modifier,
    viewModel: ProductDetailViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    var quantity by rememberSaveable {
        mutableIntStateOf(0)
    }
    LaunchedEffect(id) {
        viewModel.loadProductById(id)
    }

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(title = {}, navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(arrowBack, contentDescription = "back")
                }
            })


        },
        floatingActionButton = {
            Button(
                onClick = { viewModel.addToCart(id, quantity) }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {

                Text(text = "Add to Cart")
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {


            when (uiState) {

                is ProductDetailUiState.Loading -> {
                    CircularProgressIndicator()
                }

                is ProductDetailUiState.Success -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    ) {
                        AsyncImage(
                            model = uiState.product.imageUrl,
                            contentDescription = uiState.product.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.5f)
                        )
                        Text(text = uiState.product.description)

                        TextField(
                            value = quantity.toString(),
                            onValueChange = { newValue ->
                                val intValue = newValue.toIntOrNull() ?: 0
                                quantity = intValue
                            },
                            label = { Text("Quantity") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                is ProductDetailUiState.Error -> {
                    Text(text = uiState.message)
                }
            }
        }
    }

}