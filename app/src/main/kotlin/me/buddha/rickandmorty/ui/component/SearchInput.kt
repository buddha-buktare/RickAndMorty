package me.buddha.rickandmorty.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.buddha.rickandmorty.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchInput(
  searchInput: String,
  onSearchInputChange: (String) -> Unit,
  modifier: Modifier = Modifier,
) {
  val keyboardController = LocalSoftwareKeyboardController.current

  TextField(
    value = searchInput,
    onValueChange = { onSearchInputChange(it) },
    modifier = modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(50))
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
    ),
    keyboardActions = KeyboardActions(
      onSearch = { keyboardController?.hide() }
    ),
    placeholder = {
      Text(
        text = "Search Character...",
        modifier = Modifier.padding(end = 8.dp),
        fontSize = 20.sp,
        fontFamily = FontFamily.SansSerif,
        color = colorResource(id = R.color.white),
      )
    },
    colors = TextFieldDefaults.textFieldColors(
      focusedIndicatorColor = Color.Transparent,
      unfocusedIndicatorColor = Color.Transparent,
    )
  )
}