package me.buddha.rickandmorty.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import me.buddha.rickandmorty.domain.ScreenState.Error
import me.buddha.rickandmorty.domain.ScreenState.Loading
import me.buddha.rickandmorty.domain.ScreenState.Success

@Composable
internal fun CharactersListScreen(
  viewModel: MainViewModel,
  navController: NavHostController,
) {

  when (val state = viewModel.screenState) {
    is Error -> CharactersListErrorState(
      errorTitle = state.errorMessage ?: "Something went wrong! \n Please try again.",
      onRetryClick = viewModel::fetchCharacters
    )

    is Loading -> {}
    is Success -> CharactersListSuccessState(
      viewModel = viewModel,
      navController = navController,
    )
  }
}