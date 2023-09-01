package presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProductDetailPage(viewModel: ProductViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val product = uiState.getProduct(uiState.currentIndex)

    Column() {
        Spacer(modifier = Modifier.height(20.dp))
        TopAppBar(
            title = { Text(product.name ?: "") },
            backgroundColor = Color.Transparent,
            navigationIcon = {
                IconButton(onClick = {
                    viewModel.navigateTo("Products")
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            contentColor = Color.Transparent,
            elevation = 0.dp
        )

        Box(
            modifier = Modifier.padding(20.dp)
        ) {
            ProductCardCell(viewModel, uiState.currentIndex)
        }
    }
}