package me.buddha.rickandmorty.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import me.buddha.rickandmorty.domain.Destination
import me.buddha.rickandmorty.domain.extention.OnEndReached
import me.buddha.rickandmorty.ui.component.CharacterListItem
import me.buddha.rickandmorty.ui.component.FilterChip

@Composable
internal fun CharactersListScreen(
  viewModel: MainViewModel,
  navController: NavHostController,
) {

  val state = rememberLazyListState()

  Column(
    modifier = Modifier.fillMaxSize(),
  ) {

    Text(
      text = "Filters",
      modifier = Modifier.padding(horizontal = 16.dp),
      fontSize = 20.sp,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
    )

    LazyRow(
      contentPadding = PaddingValues(8.dp),
    ) {
      items(viewModel.filters) { filter ->
        FilterChip(
          title = filter.title,
          onClick = { viewModel.onFilterChipClick(filter) },
          isApplied = viewModel.appliedFilters.contains(filter),
          modifier = Modifier.padding(8.dp)
        )
      }
    }

    LazyColumn(
      state = state,
      modifier = Modifier.fillMaxSize(),
    ) {
      items(viewModel.characters) { character ->
        if(viewModel.filterVerify(character)) {
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
  }

  state.OnEndReached {
    viewModel.fetchCharacters()
  }
}