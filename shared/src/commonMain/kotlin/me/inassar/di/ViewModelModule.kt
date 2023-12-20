package me.inassar.di

import me.inassar.presentation.screens.home.HomeViewModel
import org.koin.dsl.module

/**
 * Created by Ahmed Nassar on 5/27/23.
 */

val viewModelModule = module {
    factory { HomeViewModel(get(),get(),get()) }
}