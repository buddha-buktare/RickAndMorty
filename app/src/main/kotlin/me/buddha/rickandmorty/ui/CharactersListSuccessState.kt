package me.buddha.rickandmorty.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import me.buddha.rickandmorty.domain.Destination.CharacterDetails
import me.buddha.rickandmorty.domain.extention.OnEndReached
import me.buddha.rickandmorty.ui.component.CharacterListItem
import me.buddha.rickandmorty.ui.component.FilterChip
import me.buddha.rickandmorty.ui.component.SearchInput

@Composable
fun CharactersListSuccessState(
  viewModel: MainViewModel,
  navController: NavHostController,
) {

  val state = rememberLazyListState()
  var searchInput by remember { mutableStateOf("") }

  Column(
    modifier = Modifier.fillMaxSize(),
  ) {

    SearchInput(
      searchInput = searchInput,
      onSearchInputChange = { searchInput = it },
      modifier = Modifier.padding(16.dp),
    )

    LazyRow(
      contentPadding = PaddingValues(vertical = 8.dp),
      modifier = Modifier.padding(horizontal = 8.dp)
    ) {
      items(viewModel.filters) { filter ->
        FilterChip(
          title = filter.title,
          isApplied = viewModel.appliedFilters.contains(filter),
          modifier = Modifier
            .clickable { viewModel.onFilterChipClick(filter) }
            .padding(8.dp),
        )
      }
    }

    LazyColumn(
      state = state,
      modifier = Modifier.fillMaxSize(),
    ) {
      items(viewModel.characters) { character ->
        if (viewModel.filterVerify(character) && character.name.contains(
            searchInput,
            ignoreCase = true
          )
        ) {
          CharacterListItem(
            character = character,
            onClick = {
              viewModel.selectedCharacter = character
              navController.navigate(CharacterDetails.route)
            },
          )
        }
      }
    }
  }

  state.OnEndReached {
    viewModel.fetchCharacters()
  }
}