package me.buddha.rickandmorty.data.model

data class Character(
  val id: Int,
  val name: String,
  val status: String,
  val species: String,
  val gender: String,
  val origin: Location,
  val location: Location,
  val image: String,
  var isStarred: Boolean = false,
)
