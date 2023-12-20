package me.inassar.di

import me.inassar.domain.usecases.GetBannersUseCase
import me.inassar.domain.usecases.GetCategoryUseCase
import me.inassar.domain.usecases.GetProductUseCase
import org.koin.dsl.module


val useCaseModule = module {
    single { GetBannersUseCase(get()) }
    single { GetCategoryUseCase(get()) }
    single { GetProductUseCase(get()) }
}