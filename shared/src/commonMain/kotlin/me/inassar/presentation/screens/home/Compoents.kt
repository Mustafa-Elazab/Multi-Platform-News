package me.inassar.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import me.inassar.common.composable.LoadImage
import me.inassar.data.remote.dto.BannerDTO
import me.inassar.data.remote.dto.CategoryDTO
import me.inassar.data.remote.dto.ProductDTO

@Composable
fun BannersList(
    banners: List<BannerDTO?>
) {
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(banners) { banner ->
            BannerItem(
                banner = banner!!
            )
        }
    }
}

@Composable
fun CategoriesList(
    categories: List<CategoryDTO?>
) {
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(categories) { category ->
            CategoryItem(
                category = category!!
            )
        }
    }
}

@Composable
fun ProductsList(
    products: List<ProductDTO?>
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            top = 8.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 8.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(items = products, key = { product ->
            product?.id!!
        }) { product ->
            ProductItem(
                product = product!!
            )
        }
    }
}

@Composable
fun BannerItem(banner: BannerDTO) {

    Column(modifier = Modifier.padding(2.dp)) {
        LoadImage(
            modifier = Modifier.height(120.dp).width(200.dp),
            imagePath = banner.image!!,
            contentDescription = banner.id.toString(),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun CategoryItem(category: CategoryDTO) {

    Card(modifier = Modifier.padding(2.dp)) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoadImage(
                modifier = Modifier.height(120.dp).width(200.dp),
                imagePath = category.image!!,
                contentDescription = category.id.toString(),
                contentScale = ContentScale.FillBounds
            )
            Text(category.name!!, modifier = Modifier.fillMaxWidth().align(Alignment.End))
        }
    }
}

@Composable
fun ProductItem(product: ProductDTO) {

    Column(modifier = Modifier.padding(2.dp)) {
        LoadImage(
            modifier = Modifier.height(120.dp).width(200.dp),
            imagePath = product.image!!,
            contentDescription = product.id.toString(),
            contentScale = ContentScale.FillBounds
        )
    }
}