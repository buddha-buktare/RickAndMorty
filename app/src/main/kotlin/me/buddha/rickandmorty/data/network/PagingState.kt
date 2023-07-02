package me.buddha.rickandmorty.data.network

import me.buddha.rickandmorty.data.model.Error
import me.buddha.rickandmorty.data.network.response.CharacterListResponse

data class PagingState<out T>(
  val data: T? = null,
  val error: Error? = null,
  val isLoading: Boolean = false,
  val hasMorePages: Boolean = false,
) {
  companion object {

    fun <T> success(data: T): PagingState<T> {
      val pagingResponse = data as CharacterListResponse
      return PagingState(data = data, hasMorePages = pagingResponse.info.next != null)
    }

    fun <T> loading(): PagingState<T> =
      PagingState(isLoading = true)

    fun <T> error(throwable: Throwable): PagingState<T> {
      return PagingState(
        error = Error(
          message = "Something went wrong! \n Please try again."
        )
      )
    }
  }
}