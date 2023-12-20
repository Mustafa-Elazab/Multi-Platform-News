package me.inassar.domain.repository

import kotlinx.coroutines.flow.Flow
import me.inassar.common.network.ResponseResource
import me.inassar.data.remote.dto.BannersDTO
import me.inassar.data.remote.dto.CategoriesDTO
import me.inassar.data.remote.dto.ProductsDTO
import me.inassar.data.remote.dto.ProductsDetailDTO

interface HomeRepository {
    suspend fun getBanners(): Flow<ResponseResource<BannersDTO>>

    suspend fun getCategories(): Flow<ResponseResource<CategoriesDTO>>

    suspend fun getProducts(): Flow<ResponseResource<ProductsDTO>>

    suspend fun getProductDetail(id: String): Flow<ResponseResource<ProductsDetailDTO>>

    suspend fun getCategoryDetail(id: String): Flow<ResponseResource<ProductsDTO>>
}