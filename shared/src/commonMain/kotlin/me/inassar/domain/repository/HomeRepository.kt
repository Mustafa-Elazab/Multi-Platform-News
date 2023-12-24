package me.inassar.domain.repository

import kotlinx.coroutines.flow.Flow
import me.inassar.common.network.ResponseResource
import me.inassar.data.remote.dto.BannersDTO
import me.inassar.data.remote.dto.CategoriesDTO
import me.inassar.data.remote.dto.ProductsDTO
import me.inassar.data.remote.dto.ProductsDetailDTO
import me.inassar.domain.model.ProductsDetailModel
import me.inassar.domain.model.ProductsModel

interface HomeRepository {
    suspend fun getBanners(): Flow<ResponseResource<BannersDTO>>

    suspend fun getCategories(): Flow<ResponseResource<CategoriesDTO>>

    suspend fun getProducts(): Flow<ResponseResource<ProductsModel>>

    suspend fun getProductDetail(id: String): Flow<ResponseResource<ProductsDetailModel>>

    suspend fun getCategoryDetail(id: String): Flow<ResponseResource<ProductsModel>>
}