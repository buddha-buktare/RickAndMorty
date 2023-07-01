package me.buddha.rickandmorty.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import me.buddha.rickandmorty.domain.Destination
import me.buddha.rickandmorty.domain.extention.OnEndReached
import me.buddha.rickandmorty.ui.component.CharacterListItem

@Composable
internal fun CharactersListScreen(
  viewModel: MainViewModel,
  navController: NavHostController,
) {

  val state = rememberLazyListState()

  Box(
    modifier = Modifier.fillMaxSize(),
  ) {
    LazyColumn(
      state = state,
      modifier = Modifier.fillMaxSize(),
    ) {
      items(viewModel.characters) { character ->
        Log.d("Compose Character", character.toString())
        CharacterListItem(
          character = character,
          onClick = {
            viewModel.selectedCharacter = character
            navController.navigate(Destination.CharacterDetails.route)
          },
        )
      }
    }
  }

  state.OnEndReached {
    viewModel.fetchCharacters()
  }
}