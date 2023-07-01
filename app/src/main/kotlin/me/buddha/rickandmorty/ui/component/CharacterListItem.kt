package me.buddha.rickandmorty.ui.component

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import me.buddha.rickandmorty.data.model.Character

@Composable
internal fun CharacterListItem(
  character: Character,
  onClick: () -> Unit,
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(
        horizontal = 10.dp,
        vertical = 4.dp,
      )
      .height(100.dp)
      .clip(RoundedCornerShape(16.dp))
      .background(Color.Yellow)
      .clickable { onClick() },
    verticalAlignment = Alignment.CenterVertically,
  ) {
    AsyncImage(
      model = character.image,
      contentDescription = null,
      modifier = Modifier
        .fillMaxHeight(),
      contentScale = ContentScale.Fit,
    )
    Spacer(modifier = Modifier.width(10.dp))
    Text(
      text = character.name,
      modifier = Modifier.padding(end = 8.dp),
      fontSize = 20.sp,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
    )
  }
}

// @Preview
// @Composable
// fun CharacterListItemPreview() {
//   RickAndMortyTheme {
//     CharacterListItem()
//   }
// }