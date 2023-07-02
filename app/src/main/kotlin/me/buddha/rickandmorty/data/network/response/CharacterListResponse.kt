package me.buddha.rickandmorty.data.network.response

import me.buddha.rickandmorty.data.model.Character

data class CharacterListResponse(
  val info: Info,
  val results: List<Character>,
)

data class Info(
  val count: Int,
  val pages: Int,
  val next: String?,
  val prev: String,
)
