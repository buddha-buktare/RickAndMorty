package me.buddha.rickandmorty.domain

sealed class Destination(val route: String) {
  object CharatersList: Destination("characters_list")
  object CharacterDetails: Destination("character_details")
}
