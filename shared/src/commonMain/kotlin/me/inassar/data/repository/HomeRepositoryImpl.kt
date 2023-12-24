package me.inassar.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.inassar.common.network.ResponseResource
import me.inassar.common.network.toUserErrorMessage
import me.inassar.data.mapper.toProductDetailModel
import me.inassar.data.mapper.toProductsModel
import me.inassar.data.remote.RemoteDataSource
import me.inassar.data.remote.dto.BannersDTO
import me.inassar.data.remote.dto.CategoriesDTO
import me.inassar.data.remote.dto.ProductsDTO
import me.inassar.data.remote.dto.ProductsDetailDTO
import me.inassar.domain.model.ProductsDetailModel
import me.inassar.domain.model.ProductsModel
import me.inassar.domain.repository.HomeRepository

class HomeRepositoryImpl(private val remoteDataSource: RemoteDataSource) : HomeRepository {
    override suspend fun getBanners(): Flow<ResponseResource<BannersDTO>> = flow {

        when (val result = remoteDataSource.getBanners()) {
            is ResponseResource.Error -> {
                emit(ResponseResource.error(error = result.error.toUserErrorMessage()))
            }
            is ResponseResource.Success -> {
                emit(ResponseResource.success(data = result.data))
            }
        }
    }

    override suspend fun getCategories(): Flow<ResponseResource<CategoriesDTO>> = flow {
        when (val result = remoteDataSource.getCategories()) {
            is ResponseResource.Error -> {
                emit(ResponseResource.error(error = result.error.toUserErrorMessage()))
            }
            is ResponseResource.Success -> {
                emit(ResponseResource.success(data = result.data))
            }
        }
    }

    override suspend fun getProducts(): Flow<ResponseResource<ProductsModel>> = flow {
        when (val result = remoteDataSource.getProducts()) {
            is ResponseResource.Error -> {
                emit(ResponseResource.error(error = result.error.toUserErrorMessage()))
            }
            is ResponseResource.Success -> {
                emit(ResponseResource.success(data = result.data.toProductsModel()))
            }
        }
    }

    override suspend fun getProductDetail(id: String): Flow<ResponseResource<ProductsDetailModel>> =
        flow {
            when (val result = remoteDataSource.getProductDetail(id)) {
                is ResponseResource.Error -> {
                    emit(ResponseResource.error(error = result.error.toUserErrorMessage()))
                }
                is ResponseResource.Success -> {
                    emit(ResponseResource.success(data = result.data.toProductDetailModel()))
                }
            }
        }

    override suspend fun getCategoryDetail(id: String): Flow<ResponseResource<ProductsModel>> = flow {
        when (val result = remoteDataSource.getCategoryDetail(id)) {
            is ResponseResource.Error -> {
                emit(ResponseResource.error(error = result.error.toUserErrorMessage()))
            }
            is ResponseResource.Success -> {
                emit(ResponseResource.success(data = result.data.toProductsModel()))
            }
        }
    }
}