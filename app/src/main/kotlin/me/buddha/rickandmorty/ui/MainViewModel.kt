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
import me.buddha.rickandmorty.domain.Filter
import me.buddha.rickandmorty.domain.Filter.ALIVE
import me.buddha.rickandmorty.domain.Filter.ALL
import me.buddha.rickandmorty.domain.Filter.DEAD
import me.buddha.rickandmorty.domain.Filter.FEMALE
import me.buddha.rickandmorty.domain.Filter.MALE
import me.buddha.rickandmorty.domain.Filter.STARRED
import me.buddha.rickandmorty.domain.ScreenState
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
  val filters = listOf(ALL, STARRED, ALIVE, DEAD, MALE, FEMALE)
  val appliedFilters = mutableStateListOf<Filter>()
  var screenState by mutableStateOf<ScreenState>(ScreenState.Loading)
  private var hasMorePages by mutableStateOf(true)

  init {
    fetchCharacters()
  }

  fun fetchCharacters() {
    if (hasMorePages) {
      viewModelScope.launch {
        repository.getCharacters(characters.getNextPageNumber()).onEach { pagingState ->
          pagingState.data?.results?.let {
            characters.addPageData(it.toMutableStateList())
            screenState = ScreenState.Success

            hasMorePages = pagingState.hasMorePages
          }
          pagingState.error?.let {
            if (characters.isEmpty()) {
              screenState = ScreenState.Error(it.message)
            }
          }
        }.launchIn(viewModelScope)
      }
    }
  }

  internal fun updateStar() {
    characters.firstOrNull { it.id == selectedCharacter?.id }?.run {
      isStarred = !isStarred
      selectedCharacter = this
    }
  }

  internal fun onFilterChipClick(filter: Filter) {
    if(appliedFilters.contains(filter)) {
      appliedFilters.remove(filter)
    } else {
      appliedFilters.add(filter)
    }
  }

  internal fun filterVerify(character: Character): Boolean {
    if(appliedFilters.contains(ALL)) return true
    if(appliedFilters.contains(ALIVE) && character.status != "Alive") return false
    if(appliedFilters.contains(DEAD) && character.status != "Dead") return false
    if(appliedFilters.contains(FEMALE) && character.gender != "Female") return false
    if(appliedFilters.contains(MALE) && character.gender != "Male") return false
    if(appliedFilters.contains(STARRED) && !character.isStarred) return false
    return true
  }

}