package me.buddha.rickandmorty.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import me.buddha.rickandmorty.data.model.Character
import me.buddha.rickandmorty.domain.repository.MainRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  val repository: MainRepository
): ViewModel() {

  val characters = mutableStateListOf<Character>()
  val hasMorePages by mutableStateOf(true)

  init {
    fetchCharacters()
  }

  fun fetchCharacters() {
    if(hasMorePages) {

    }
  }


}