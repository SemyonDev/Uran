package com.task.di

import com.task.fileexhibitsloader.ExhibitsLoaderImpl
import com.task.model.loader.ExhibitsLoader
import org.koin.dsl.module

val loaderModule = module {
    single<ExhibitsLoader> {
        ExhibitsLoaderImpl(get())
    }
}