package me.buddha.rickandmorty.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.neverEqualPolicy
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import me.buddha.rickandmorty.data.model.Character
import me.buddha.rickandmorty.domain.extention.addPageData
import me.buddha.rickandmorty.domain.extention.getNextPageNumber
import me.buddha.rickandmorty.domain.repository.MainRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val repository: MainRepository,
): ViewModel() {

  val characters = mutableStateListOf<Character>()
  var selectedCharacter: Character? by mutableStateOf(null, neverEqualPolicy())

  init {
    fetchCharacters()
  }

  fun fetchCharacters() {
    viewModelScope.launch {
      repository.getCharacters(characters.getNextPageNumber()).onEach {
        characters.addPageData(it.toMutableStateList())
      }.launchIn(viewModelScope)
    }
  }

  fun updateStar() {
    characters.firstOrNull { it.id == selectedCharacter?.id }?.run {
      isStarred = !isStarred
      selectedCharacter = this
    }
  }
}