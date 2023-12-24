package me.inassar.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsDetailDTO(

    @SerialName("data")
    val `data`: ProductDTO? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("status")
    val status: Boolean? = null
)


@Serializable
data class ProductsDTO(
    @SerialName("data")
    val `data`: ProductPaginationDTO? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("status")
    val status: Boolean? = null
)

@Serializable
data class ProductPaginationDTO(
    @SerialName("current_page")
    val currentPage: Int?=null,
    @SerialName("data")
    val `data`: List<ProductDTO>?=null,
    @SerialName("first_page_url")
    val firstPageUrl: String?=null,
    @SerialName("from")
    val from: Int?=null,
    @SerialName("last_page")
    val lastPage: Int?=null,
    @SerialName("last_page_url")
    val lastPageUrl: String?=null,
    @SerialName("next_page_url")
    val nextPageUrl: String?=null,
    @SerialName("path")
    val path: String?=null,
    @SerialName("per_page")
    val perPage: Int?=null,
    @SerialName("prev_page_url")
    val prevPageUrl: Int?=null,
    @SerialName("to")
    val to: Int?=null,
    @SerialName("total")
    val total: Int?=null


)

@Serializable
data class ProductDTO(
    @SerialName("description")
    val description: String?=null,
    @SerialName("discount")
    val discount: Int?=null,
    @SerialName("id")
    val id: Int?=null,
    @SerialName("image")
    val image: String?=null,
    @SerialName("images")
    val images: List<String>?=null,
    @SerialName("in_cart")
    val inCart: Boolean?=null,
    @SerialName("in_favorites")
    val inFavorites: Boolean?=null,
    @SerialName("name")
    val name: String?=null,
    @SerialName("old_price")
    val oldPrice: Double?=null,
    @SerialName("price")
    val price: Double?=null

)
