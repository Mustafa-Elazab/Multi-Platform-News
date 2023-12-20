package me.inassar.presentation.screens.home

import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.launch
import me.inassar.common.network.ResponseResource
import me.inassar.domain.usecases.GetBannersUseCase
import me.inassar.domain.usecases.GetCategoryUseCase
import me.inassar.domain.usecases.GetProductUseCase
import me.inassar.presentation.screens.utils.BaseViewModel
import me.inassar.presentation.screens.utils.ResourceUiState

class HomeViewModel(
    private val bannersUseCase: GetBannersUseCase,
    private val categoryUseCase: GetCategoryUseCase,
    private val productUseCase: GetProductUseCase
) :
    BaseViewModel<HomeContracts.Event, HomeContracts.State, HomeContracts.Effect>() {


    init {
        getBanners()
        getCategories()
        getProducts()
    }


    override fun createInitialState(): HomeContracts.State =
        HomeContracts.State(
            banners = ResourceUiState.Idle,
            categories = ResourceUiState.Idle,
            products = ResourceUiState.Idle
        )

    override fun handleEvent(event: HomeContracts.Event) {
        when (event) {
            is HomeContracts.Event.OnBannerClick -> {}
            is HomeContracts.Event.OnCategoryClick -> {}
            HomeContracts.Event.OnFavoritesClick -> {}
            is HomeContracts.Event.OnProductClick -> {}
        }
    }

    private fun getBanners() {
        setState { copy(banners = ResourceUiState.Loading) }
        coroutineScope.launch {
            bannersUseCase().collect { result ->
                when (result) {
                    is ResponseResource.Error -> {
                        setState { copy(banners = ResourceUiState.Error()) }
                    }

                    is ResponseResource.Success -> {
                        setState {
                            copy(
                                banners = if (result.data.data?.isEmpty() == true)
                                    ResourceUiState.Empty
                                else
                                    ResourceUiState.Success(result.data)
                            )
                        }
                    }
                }
            }
        }

    }

    private fun getCategories() {
        coroutineScope.launch {
            setState { copy(categories = ResourceUiState.Loading) }
            categoryUseCase().collect { result ->
                when (result) {
                    is ResponseResource.Error -> {
                        setState { copy(categories = ResourceUiState.Error()) }
                    }

                    is ResponseResource.Success -> {
                        setState {
                            copy(
                                categories = if (result.data.data?.data?.isEmpty() == true)
                                    ResourceUiState.Empty
                                else
                                    ResourceUiState.Success(result.data)
                            )
                        }
                    }
                }
            }
        }
    }


    private fun getProducts() {
        coroutineScope.launch {
            setState { copy(products = ResourceUiState.Loading) }
            productUseCase().collect { result ->
                when (result) {
                    is ResponseResource.Error -> {
                        setState { copy(products = ResourceUiState.Error()) }
                    }

                    is ResponseResource.Success -> {
                        setState {
                            copy(
                                products = if (result.data.data?.data?.isEmpty() == true)
                                    ResourceUiState.Empty
                                else
                                    ResourceUiState.Success(result.data)
                            )
                        }
                    }
                }
            }
        }
    }
}