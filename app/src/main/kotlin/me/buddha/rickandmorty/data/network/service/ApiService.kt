package me.buddha.rickandmorty.data.network.service

import me.buddha.rickandmorty.data.network.response.CharacterListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

  @GET("character")
  suspend fun getCharactersList(): CharacterListResponse

}