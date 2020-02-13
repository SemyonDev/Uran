package com.task.uran.di

import com.task.uran.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    viewModel { MainActivityViewModel(get()) }
}