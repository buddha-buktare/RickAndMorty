package me.buddha.rickandmorty.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import me.buddha.rickandmorty.data.network.service.ApiService
import me.buddha.rickandmorty.domain.repository.MainRepository

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

  @Provides
  @ViewModelScoped
  fun provideRepository(
    service: ApiService
  ): MainRepository = MainRepository(service)
}