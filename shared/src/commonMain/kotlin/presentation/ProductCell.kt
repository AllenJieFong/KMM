package presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.Product
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun ProductCardCell(viewModel: ProductViewModel, index: Int) {
    val uiState by viewModel.uiState.collectAsState()
    val product = uiState.getProduct(index)

    Column(
        Modifier.fillMaxSize().clickable {
            viewModel.setCurrentIndex(index)
            viewModel.navigateTo("ProductDetail")
        },
        horizontalAlignment = Alignment.Start
    ) {
        //圖片
        KamelImage(
            asyncPainterResource(product.img_url ?: ""),
            "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().aspectRatio(1.5f).clip(RoundedCornerShape(16.dp))
        )
        Spacer(modifier = Modifier.height(4.dp))

        //名稱
        Text(
            text = product?.name ?: "",
            style = TextStyle(
                fontSize = 16.sp
            ),
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(4.dp))

        //評價與訂購數
        Row {
            Icon(
                Icons.Rounded.Star,
                contentDescription = null,
                tint = Color.Cyan
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "${product.rating_star} (${product.rating_count}) | ${product.display_order_count}個已訂購",
                color = Color.Gray,
                style = TextStyle(
                    fontSize = 14.sp
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))

        //價錢
        Text(
            text = "TWD ${product.display_sale_price} 起",
            style = TextStyle(
                fontSize = 14.sp
            ),
            fontWeight = FontWeight.Bold
        )
    }
}
