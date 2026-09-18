package pe.edu.upc.easyvet.features.home.presentation.productdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import pe.edu.upc.easyvet.core.visibility

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    id: Int,
    viewModel: ProductDetailViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {

    LaunchedEffect(id) {
        viewModel.loadProductById(id)
    }

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(title = {}, navigationIcon =  {
                IconButton(onClick =  onBack) {
                    Icon(visibility, contentDescription = "back")
                }
            })


        }
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
                    Column(modifier = Modifier.fillMaxSize()) {
                        AsyncImage(
                            model = uiState.product.imageUrl,
                            contentDescription = uiState.product.name
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