package data.repository

import data.model.BaseResponse
import data.model.ProductsData

class ProductRepository: BaseRepository() {
    suspend fun getTopProduct(): BaseResponse<ProductsData> {
        return getApi("https://api-b2c-04.sit.kkday.com/api/v2/recommend/home/top_products?currency=TWD")
    }
}