package me.inassar.domain.model


import kotlinx.serialization.Serializable

data class ProductsDetailModel(
    val `data`: ProductModel?=null,
    val message: String?=null,
    val status: Boolean?=null
)

data class ProductsModel(
    val `data`: ProductPaginationModel?=null,
    val message: String?=null,
    val status: Boolean?=null
)
data class ProductPaginationModel(
    val current_page: Int,
    val `data`: List<ProductModel>,
    val first_page_url: String,
    val from: Int,
    val last_page: Int,
    val last_page_url: String,
    val next_page_url: String,
    val path: String,
    val per_page: Int,
    val prev_page_url: Int,
    val to: Int,
    val total: Int
)
data class ProductModel(
    val description: String,
    val discount: Int,
    val id: Int,
    val image: String,
    val images: List<String>,
    val in_cart: Boolean,
    val in_favorites: Boolean,
    val name: String,
    val old_price: Double,
    val price: Double
)