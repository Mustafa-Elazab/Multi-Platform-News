package me.inassar.presentation.screens.home

import me.inassar.data.remote.dto.BannerDTO
import me.inassar.data.remote.dto.BannersDTO
import me.inassar.data.remote.dto.CategoriesDTO
import me.inassar.data.remote.dto.ProductsDTO
import me.inassar.presentation.screens.utils.ResourceUiState
import me.inassar.presentation.screens.utils.UiEffect
import me.inassar.presentation.screens.utils.UiEvent
import me.inassar.presentation.screens.utils.UiState

interface HomeContracts {
    sealed interface Event : UiEvent {
        object OnFavoritesClick : Event
        data class OnCategoryClick(val id: Int) : Event
        data class OnProductClick(val id: Int) : Event
        data class OnBannerClick(val id: Int) : Event
    }

    data class State(
        val banners: ResourceUiState<BannersDTO>,
        val categories : ResourceUiState<CategoriesDTO>,
        val products : ResourceUiState<ProductsDTO>
    ) : UiState

    sealed interface Effect : UiEffect {
        object NavigateToFavorites : Effect
    }
}

