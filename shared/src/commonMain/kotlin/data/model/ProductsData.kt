package data.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductsData(
    val products: List<Product>
)

@Serializable
data class Product(
    val app_cheaper_than_web: Boolean?,
    val cat_key: List<String>?,
    val confirm_hour: Int?,
    val countries: List<Country>?,
    val currency: String?,
    val days: Int?,
    val decimal_rating_star: Double?,
    val discount: Double?,
    val display_order_count: String?,
    val display_price: String?,
    val display_sale_price: String?,
    val display_symbol_currency: String?,
    val duration: Int?,
    val earliest_sale_date: String?,
    val free_refund_policy: Boolean?,
    val hours: Int?,
    val id: Int?,
    val img_url: String?,
    val img_url_list: List<String>?,
    val img_webp_url: String?,
    val instant_booking: Boolean?,
    val instant_use: Boolean?,
    val introduction: String?,
    val is_display_price: Boolean?,
    val is_marketplace: Boolean?,
    val is_tourism_product: Boolean?,
    val is_zero_price: Boolean?,
    val main_cat_key: String?,
    val max_price: Int?,
    val minutes: Int?,
    val name: String?,
    val order_count: Int?,
    val price: Int?,
    val prod_oid: Int?,
    val product_labels: List<String>?,
    val promo_tag_keys: List<String>?,
    val purchase_date: String?,
    val purchase_type: String?,
    val rating_count: Int?,
    val rating_star: Int?,
    val readable_url: String?,
    val sale_price: Int?,
    val sale_status: String?,
    val show_order_count: String?,
    val supplier_award: Int?,
    val supplier_logo: String?,
    val supplier_logo_webp: String?,
    val supplier_name: String?,
    val supplier_oid_list: List<String>?,
    val theme_code: List<String>?
)

@Serializable
data class Country(
    val cities: List<City>?,
    val id: String?,
    val name: String?
)

@Serializable
data class City(
    val id: String?,
    val name: String?
)