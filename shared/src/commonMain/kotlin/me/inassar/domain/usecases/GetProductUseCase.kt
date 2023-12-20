package me.inassar.domain.usecases

import me.inassar.domain.repository.HomeRepository

class GetProductUseCase(private val repository: HomeRepository) {

    suspend operator fun invoke() = repository.getProducts()
}