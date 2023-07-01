package me.buddha.rickandmorty.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import me.buddha.rickandmorty.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchInput(
  searchInput: String,
  onSearchInputChange: (String) -> Unit,
  modifier: Modifier = Modifier,
) {
  TextField(
    value = searchInput,
    onValueChange = { onSearchInputChange(it) },
    modifier = modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(16.dp))
      .background(Color.LightGray),
    leadingIcon = {
      Icon(
        painter = painterResource(id = R.drawable.ic_search),
        contentDescription = null,
        modifier = Modifier.size(24.dp),
        tint = Color.White,
      )
    },
    keyboardOptions = KeyboardOptions(
      imeAction = ImeAction.Search
    )
  )
}