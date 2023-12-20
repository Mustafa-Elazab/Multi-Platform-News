package me.inassar.domain.usecases

import me.inassar.domain.repository.HomeRepository

class GetCategoryUseCase (private val repository: HomeRepository) {
    suspend operator fun invoke() = repository.getCategories()
}