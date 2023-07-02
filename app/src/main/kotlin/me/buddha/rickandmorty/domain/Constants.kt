package me.buddha.rickandmorty.domain

class Constants {
  companion object {
    const val BASE_URL = "https://rickandmortyapi.com/api/"
  }
}

enum class Filter(val title: String) {
  ALL("All"),
  ALIVE("Alive"),
  DEAD("Dead"),
  FEMALE("Female"),
  MALE("Male"),
  STARRED("Starred"),
}