package me.buddha.rickandmorty.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.buddha.rickandmorty.domain.RickAndMorty
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

  @Singleton
  @Provides
  fun provideApplication(
    @ApplicationContext context: Context
  ): RickAndMorty = context as RickAndMorty
}