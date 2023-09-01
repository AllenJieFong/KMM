import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import presentation.ProductDetailPage
import presentation.ProductViewModel
import presentation.ProductsPage

@Composable
fun KKTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = MaterialTheme.colors.copy(primary = Color.Black),
        shapes = MaterialTheme.shapes.copy(
            small = AbsoluteCutCornerShape(0.dp),
            medium = AbsoluteCutCornerShape(0.dp),
            large = AbsoluteCutCornerShape(0.dp)
        )
    ) {
        content()
    }
}

@Composable
fun App() {
    KKTheme {
        val productViewModel = getViewModel(Unit, viewModelFactory { ProductViewModel() })

        val currentPage = productViewModel.currentPage.collectAsState()
        when (currentPage.value) {
            "Products" -> {
                ProductsPage(productViewModel)
            }

            "ProductDetail" -> {
                ProductDetailPage(productViewModel)
            }
        }
    }
}

expect fun getPlatformName(): String