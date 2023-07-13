package com.bacon.pexels.di

import com.bacon.domain.repositories.PexelsRepository
import com.bacon.pexels.data.repositories.PexelsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindPexelsRepository(
        repositoryImpl: PexelsRepositoryImpl
    ): PexelsRepository
}