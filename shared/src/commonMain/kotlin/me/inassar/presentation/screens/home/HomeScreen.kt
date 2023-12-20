package me.inassar.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import me.inassar.presentation.common.state.ManagementResourceUiState

class HomeScreen : Screen {
    override val key: ScreenKey = uniqueScreenKey


    @Composable
    override fun Content() {
        val homeViewModel = getScreenModel<HomeViewModel>()

        val state by homeViewModel.uiState.collectAsState()

        val navigator = LocalNavigator.currentOrThrow


        Scaffold() { padding ->

            Column() {
                Text("Banners", modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp))
                ManagementResourceUiState(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxWidth()
                        .height(180.dp),
                    resourceUiState = state.banners,
                    successView = { banners ->
                        BannersList(
                            banners = banners.data!!,
//                       onCharacterClick = { idCharacter ->
//                           charactersViewModel.setEvent(
//                               CharactersContract.Event.OnCharacterClick(
//                                   idCharacter
//                               )
//                           )
//                       }
                        )
                    },
                    onTryAgain = { /*homeViewModel.setEvent(HomeContracts.Event.OnTryCheckAgainClick)*/ },
                    onCheckAgain = { /*homeViewModel.setEvent(HomeContracts.Event.OnTryCheckAgainClick)*/ },
                )
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Text("Categories")
                    Text("See All", color = Color.Red )
                }
                ManagementResourceUiState(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxWidth()
                        .height(200.dp),
                    resourceUiState = state.categories,
                    successView = { categories ->
                        CategoriesList(
                            categories = categories.data!!.data!!,
//                       onCharacterClick = { idCharacter ->
//                           charactersViewModel.setEvent(
//                               CharactersContract.Event.OnCharacterClick(
//                                   idCharacter
//                               )
//                           )
//                       }
                        )
                    },
                    onTryAgain = { /*homeViewModel.setEvent(HomeContracts.Event.OnTryCheckAgainClick)*/ },
                    onCheckAgain = { /*homeViewModel.setEvent(HomeContracts.Event.OnTryCheckAgainClick)*/ },
                )

                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Text("Products")
                    Text("See All", color = Color.Red )
                }
                ManagementResourceUiState(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxWidth()
                        .height(200.dp),
                    resourceUiState = state.products,
                    successView = { products ->
                        ProductsList(
                            products = products.data!!.data!!,
//                       onCharacterClick = { idCharacter ->
//                           charactersViewModel.setEvent(
//                               CharactersContract.Event.OnCharacterClick(
//                                   idCharacter
//                               )
//                           )
//                       }
                        )
                    },
                    onTryAgain = { /*homeViewModel.setEvent(HomeContracts.Event.OnTryCheckAgainClick)*/ },
                    onCheckAgain = { /*homeViewModel.setEvent(HomeContracts.Event.OnTryCheckAgainClick)*/ },
                )

            }
        }
    }
}