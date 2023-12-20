package me.inassar.domain.usecases

import kotlinx.coroutines.flow.Flow
import me.inassar.common.network.ResponseResource
import me.inassar.data.remote.dto.BannersDTO
import me.inassar.domain.repository.HomeRepository

class GetBannersUseCase(private val repository: HomeRepository) {
    suspend operator fun invoke() = repository.getBanners()
}