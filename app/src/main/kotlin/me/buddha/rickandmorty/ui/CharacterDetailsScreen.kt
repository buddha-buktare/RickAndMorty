package me.buddha.rickandmorty.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.buddha.rickandmorty.data.model.Character

@Composable
fun CharacterDetailsScreen(
  character: Character,
) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .padding(8.dp)
      .clip(RoundedCornerShape(16.dp))
      .background(Color(222227))
  ) {
    Column(
      modifier = Modifier.fillMaxWidth(),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      AsyncImage(
        model = "",
        contentDescription = null,
        modifier = Modifier.height(200.dp)
      )
      Spacer(modifier = Modifier.height(16.dp))

    }
  }
}