package me.buddha.rickandmorty.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterChip(
  title: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  isApplied: Boolean = false,
) {
  Text(
    text = title,
    modifier = modifier
      .clip(RoundedCornerShape(16.dp))
      .background(if(isApplied) Color.Magenta else Color.Green)
      .padding(8.dp)
      .clickable { onClick() },
    fontSize = 20.sp,
    maxLines = 1,
    overflow = TextOverflow.Ellipsis,
  )
}