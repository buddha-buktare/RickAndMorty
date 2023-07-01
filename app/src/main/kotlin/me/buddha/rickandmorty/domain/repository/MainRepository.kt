package me.buddha.rickandmorty.domain.repository

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import me.buddha.rickandmorty.data.network.service.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
  private val service: ApiService
) {

  suspend fun getCharacters() = flow {
    emit(service.getCharactersList().results)
  }.catch {
    emit(emptyList())
  }
}