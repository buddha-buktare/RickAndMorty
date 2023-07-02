package me.buddha.rickandmorty.domain.repository

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import me.buddha.rickandmorty.data.network.PagingState
import me.buddha.rickandmorty.data.network.service.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
  private val service: ApiService
) {

  suspend fun getCharacters(page: Int) = flow {
    emit(PagingState.success(service.getCharactersList(page)))
  }.catch {
    emit(PagingState.error(it))
  }
}