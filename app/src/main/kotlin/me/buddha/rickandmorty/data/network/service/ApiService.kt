package me.buddha.rickandmorty.data.network.service

import me.buddha.rickandmorty.data.network.response.CharacterListResponse
import retrofit2.http.GET

interface ApiService {

  @GET("character")
  suspend fun getCharactersList(): CharacterListResponse

}