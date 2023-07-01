package me.buddha.rickandmorty.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.buddha.rickandmorty.R

@Composable
fun FilterChip(
  title: String,
  modifier: Modifier = Modifier,
  isApplied: Boolean = false,
) {
  Text(
    text = title,
    modifier = modifier
      .clip(RoundedCornerShape(50))
      .background(if (isApplied) colorResource(id = R.color.white) else colorResource(id = R.color.grey))
      .padding(16.dp),
    fontSize = 20.sp,
    maxLines = 1,
    overflow = TextOverflow.Ellipsis,
    fontFamily = FontFamily.SansSerif,
    color = if (isApplied) colorResource(id = R.color.grey) else colorResource(id = R.color.white),
  )
}