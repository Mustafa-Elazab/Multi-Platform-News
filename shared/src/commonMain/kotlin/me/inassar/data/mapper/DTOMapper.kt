package me.inassar.data.mapper

import me.inassar.data.remote.dto.ProductDTO
import me.inassar.data.remote.dto.ProductPaginationDTO
import me.inassar.data.remote.dto.ProductsDTO
import me.inassar.data.remote.dto.ProductsDetailDTO
import me.inassar.domain.model.ProductModel
import me.inassar.domain.model.ProductPaginationModel
import me.inassar.domain.model.ProductsDetailModel
import me.inassar.domain.model.ProductsModel

fun ProductsDTO.toProductsModel() = ProductsModel(
    data = data!!.toProductPaginationModel(),
    message = message,
    status = status
)

fun ProductPaginationDTO.toProductPaginationModel() = ProductPaginationModel(
    current_page = currentPage!!,
    data!!.map {
        it.toProductModel()
    },
    first_page_url=firstPageUrl!!,
    from=from!!,
    last_page=lastPage!!,
    last_page_url=lastPageUrl!!,
    next_page_url=nextPageUrl!!,
    path=path!!,
    per_page=perPage!!,
    prev_page_url=prevPageUrl!!,
    to=to!!,
    total=total!!
)

fun ProductsDetailDTO.toProductDetailModel() = ProductsDetailModel(
    data = data?.toProductModel(),
    message = message,
    status = status
)

fun ProductDTO.toProductModel() = ProductModel(
    description = description!!,
    discount = discount!!, id = id!!, image = image!!, images = images!!, in_cart = inCart!!,
    in_favorites = inFavorites!!, name = name!!, old_price = oldPrice!!, price = price!!
)