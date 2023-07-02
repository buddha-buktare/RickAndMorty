package me.buddha.rickandmorty.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.buddha.rickandmorty.R
import me.buddha.rickandmorty.domain.Destination
import me.buddha.rickandmorty.ui.theme.RickAndMortyTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  private val viewModel by viewModels<MainViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {

      RickAndMortyTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = colorResource(id = R.color.dark_grey)
        ) {

          val navController = rememberNavController()
          NavHost(
            navController = navController,
            startDestination = Destination.CharactersList.route,
          ) {
            composable(Destination.CharactersList.route) {
              CharactersListScreen(
                viewModel = viewModel,
                navController = navController,
              )
            }

            composable(Destination.CharacterDetails.route) {
              CharacterDetailsScreen(
                viewModel = viewModel,
                navController = navController,
              )
            }
          }
        }
      }
    }
  }
}