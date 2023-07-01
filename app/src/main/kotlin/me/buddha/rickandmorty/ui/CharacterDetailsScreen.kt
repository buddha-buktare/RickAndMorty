package me.buddha.rickandmorty.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import me.buddha.rickandmorty.R

@Composable
fun CharacterDetailsScreen(
  viewModel: MainViewModel,
  navController: NavHostController,
) {

  viewModel.selectedCharacter?.let { character ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(Color.Cyan)
    ) {
      Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        AsyncImage(
          model = character.image,
          contentDescription = null,
          modifier = Modifier.fillMaxWidth(),
          contentScale = ContentScale.Fit,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
          text = character.name,
          modifier = Modifier.padding(end = 8.dp),
          fontSize = 50.sp,
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
          textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
          text = getAnnotatedString(
            title = "Species",
            value = character.species
          ),
          modifier = Modifier.padding(end = 8.dp),
          fontSize = 25.sp,
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
          textAlign = TextAlign.Center,
        )
        Text(
          text = getAnnotatedString(
            title = "Gender",
            value = character.gender
          ),
          modifier = Modifier.padding(end = 8.dp),
          fontSize = 25.sp,
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
          textAlign = TextAlign.Center,
        )
        Text(
          text = getAnnotatedString(
            title = "Status",
            value = character.status
          ),
          modifier = Modifier.padding(end = 8.dp),
          fontSize = 25.sp,
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
          textAlign = TextAlign.Center,
        )
        Text(
          text = getAnnotatedString(
            title = "Origin",
            value = character.origin.name
          ),
          modifier = Modifier.padding(end = 8.dp),
          fontSize = 25.sp,
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
          textAlign = TextAlign.Center,
        )
        Text(
          text = getAnnotatedString(
            title = "Location",
            value = character.location.name
          ),
          modifier = Modifier.padding(end = 8.dp),
          fontSize = 25.sp,
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
          textAlign = TextAlign.Center,
        )

      }

      Icon(
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = null,
        modifier = Modifier
          .padding(12.dp)
          .clip(CircleShape)
          .background(Color.Gray)
          .size(48.dp)
          .clickable {
            navController.popBackStack()
          }
      )

      Icon(
        painter = painterResource(id = if (character.isStarred) R.drawable.ic_star_filled else R.drawable.ic_star_border),
        contentDescription = null,
        modifier = Modifier
          .padding(12.dp)
          .clip(CircleShape)
          .size(48.dp)
          .clickable {
            viewModel.updateStar()
          }
          .align(Alignment.TopEnd),
        tint = if (character.isStarred) Color.Yellow else Color.White,
      )
    }
  }
}

@Composable
private fun getAnnotatedString(
  title: String,
  value: String,
): AnnotatedString {
  return buildAnnotatedString {
    withStyle(
      SpanStyle(color = Color.Blue, fontWeight = FontWeight.SemiBold)
    ) {
      append("$title : ")
    }
    withStyle(
      SpanStyle(color = Color.Red, fontWeight = FontWeight.Normal)
    ) {
      append(value)
    }
  }
}