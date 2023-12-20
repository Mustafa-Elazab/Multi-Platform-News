package me.inassar.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import me.inassar.common.network.ResponseResource
import me.inassar.common.network.performCall
import me.inassar.data.remote.dto.BannersDTO
import me.inassar.data.remote.dto.CategoriesDTO
import me.inassar.data.remote.dto.ProductsDTO
import me.inassar.data.remote.dto.ProductsDetailDTO

interface RemoteDataSource {
    suspend fun getBanners(): ResponseResource<BannersDTO>

    suspend fun getCategories(): ResponseResource<CategoriesDTO>

    suspend fun getProducts(): ResponseResource<ProductsDTO>

    suspend fun getProductDetail(id: String): ResponseResource<ProductsDetailDTO>

    suspend fun getCategoryDetail(id: String): ResponseResource<ProductsDTO>

    /*
    * @GET("banners")
    suspend fun getBanners(): NetworkResponse<BannersDTO, ErrorResponse>


    @GET("categories")
    suspend fun getCategories(): NetworkResponse<CategoriesDTO, ErrorResponse>


    @GET("products")
    suspend fun getProducts(
        @Header("Authorization") authorization: String
    ): NetworkResponse<ProductsDTO, ErrorResponse>


    @GET("products/{id}")
    suspend fun getProductDetail(
        @Path("id") id: Int,
        @Header("Authorization") authorization: String
    ): NetworkResponse<ProductsDetailDTO, ErrorResponse>

    @GET("categories/{id}")
    suspend fun getCategoryDetail(
        @Path("id") id: Int,
        @Header("Authorization") authorization: String
    ): NetworkResponse<ProductsDTO, ErrorResponse>
    * */
}


class RemoteDataSourceImpl(private val client: HttpClient) : RemoteDataSource {

    override suspend fun getBanners(): ResponseResource<BannersDTO> = runCatching {
        val response =
            client.get { performCall(endpoint = "api/banners") }.body<BannersDTO>()
        ResponseResource.success(response)
    }.getOrElse { error ->
        ResponseResource.error(error)
    }

    override suspend fun getCategories(): ResponseResource<CategoriesDTO> = runCatching{
        val response =
            client.get { performCall(endpoint = "api/categories") }.body<CategoriesDTO>()
        ResponseResource.success(response)
    }.getOrElse{
        error ->
        ResponseResource.error(error)
    }

    override suspend fun getProducts(): ResponseResource<ProductsDTO> = runCatching {
        val response =
            client.get { performCall(endpoint = "api/products") }.body<ProductsDTO>()
        ResponseResource.success(response)
    }.getOrElse { error ->
        ResponseResource.error(error)
    }

    override suspend fun getProductDetail(id: String): ResponseResource<ProductsDetailDTO> = runCatching {
        val response =
            client.get { performCall(endpoint = "api/products/${id}") }.body<ProductsDetailDTO>()
        ResponseResource.success(response)
    }.getOrElse{
        error ->
        ResponseResource.error(error)
    }

    override suspend fun getCategoryDetail(id: String): ResponseResource<ProductsDTO> =
        runCatching {
            val response =
                client.get { performCall(endpoint = "api/categories/${id}") }.body<ProductsDTO>()
            ResponseResource.success(response)
        }.getOrElse { error ->
            ResponseResource.error(error)
        }
}