package me.buddha.rickandmorty.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import me.buddha.rickandmorty.R

@Composable
fun CharacterDetailsScreen(
  viewModel: MainViewModel,
  navController: NavHostController,
) {
  var startAnim by remember {
    mutableStateOf(false)
  }

  LaunchedEffect(Unit) {
    delay(300)
    startAnim = true
  }

  viewModel.selectedCharacter?.let { character ->

    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    ) {
      Box(
        modifier = Modifier.fillMaxWidth()
      ) {

        Box(
          modifier = Modifier
            .padding(12.dp)
            .clip(CircleShape)
            .background(color = colorResource(id = R.color.grey))
            .size(64.dp)
            .align(Alignment.CenterStart)
            .clickable {
              navController.popBackStack()
            },
          contentAlignment = Alignment.Center,
        ) {

          Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
            modifier = Modifier.size(36.dp),
            tint = colorResource(id = R.color.white)
          )
        }

        Box(
          modifier = Modifier
            .padding(12.dp)
            .clip(CircleShape)
            .background(color = colorResource(id = R.color.grey))
            .size(64.dp)
            .align(Companion.CenterEnd)
            .clickable {
              viewModel.updateStar()
            },
          contentAlignment = Alignment.Center,
        ) {

          Icon(
            painter = painterResource(id = if (character.isStarred) R.drawable.ic_star_filled else R.drawable.ic_star_border),
            contentDescription = null,
            modifier = Modifier.size(36.dp),
            tint = if (character.isStarred) colorResource(id = R.color.yellow) else colorResource(id = R.color.white),
          )
        }

      }

      AnimatedVisibility(
        visible = startAnim,
        enter = fadeIn(initialAlpha = 0.25f),
        modifier = Modifier
          .fillMaxWidth(0.65f)
          .clip(CircleShape)
          .align(Alignment.CenterHorizontally),
      ) {

        AsyncImage(
          model = character.image,
          contentDescription = null,
          contentScale = ContentScale.Fit,
        )
      }

      Spacer(modifier = Modifier.height(4.dp))

      AnimatedVisibility(
        visible = startAnim,
        enter = fadeIn(initialAlpha = 0.25f),
        modifier = Modifier
          .padding(8.dp)
          .align(Alignment.CenterHorizontally),
      ) {
        Text(
          text = character.name,
          fontSize = 50.sp,
          // maxLines = 2,
          // overflow = TextOverflow.Ellipsis,
          textAlign = TextAlign.Center,
          fontFamily = FontFamily.SansSerif,
          color = colorResource(id = R.color.white),
          fontWeight = FontWeight.ExtraBold,
        )
      }

      Spacer(modifier = Modifier.height(4.dp))

      LazyColumn {
        item {

          AnimatedVisibility(
            visible = startAnim,
            enter = slideInHorizontally (
              initialOffsetX = {
                it
              },
              animationSpec = tween(
                durationMillis = 1000,
                easing = LinearOutSlowInEasing
              )
            )
          ) {
            Spacer(modifier = Modifier.height(8.dp))
            DetailsTile(title = "Species", value = character.species)
          }
        }

        item {
          AnimatedVisibility(
            visible = startAnim,
            enter = slideInHorizontally (
              initialOffsetX = {
                -it
              },
              animationSpec = tween(
                durationMillis = 1000,
                easing = LinearOutSlowInEasing
              )
            )
          ) {
            Spacer(modifier = Modifier.height(8.dp))
            DetailsTile(title = "Gender", value = character.gender)
          }
        }

        item {
          AnimatedVisibility(
            visible = startAnim,
            enter = slideInHorizontally (
              initialOffsetX = {
                it
              },
              animationSpec = tween(
                durationMillis = 1000,
                easing = LinearOutSlowInEasing
              )
            )
          ) {
            Spacer(modifier = Modifier.height(8.dp))
            DetailsTile(title = "Status", value = character.status)
          }
        }

        item {
          AnimatedVisibility(
            visible = startAnim,
            enter = slideInHorizontally (
              initialOffsetX = {
                -it
              },
              animationSpec = tween(
                durationMillis = 1000,
                easing = LinearOutSlowInEasing
              )
            )
          ) {
            Spacer(modifier = Modifier.height(8.dp))
            DetailsTile(title = "Origin", value = character.origin.name)
          }
        }

        item {
          AnimatedVisibility(
            visible = startAnim,
            enter = slideInHorizontally (
              initialOffsetX = {
                it
              },
              animationSpec = tween(
                durationMillis = 1000,
                easing = LinearOutSlowInEasing
              )
            )
          ) {
            Spacer(modifier = Modifier.height(8.dp))
            DetailsTile(title = "Location", value = character.location.name)
          }
        }
      }
    }

  }
}

@Composable
private fun DetailsTile(
  title: String,
  value: String,
) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 8.dp, vertical = 2.dp)
      .clip(RoundedCornerShape(25))
      .background(color = colorResource(id = R.color.grey)),
  ) {
    Text(
      text = title,
      modifier = Modifier
        .padding(16.dp)
        .align(Companion.CenterStart),
      fontSize = 25.sp,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
      textAlign = TextAlign.Start,
      color = colorResource(id = R.color.white),
      fontWeight = FontWeight.ExtraBold,
    )

    Text(
      text = value,
      modifier = Modifier
        .fillMaxWidth(0.6f)
        .padding(16.dp)
        .align(Companion.CenterEnd),
      fontSize = 25.sp,
      maxLines = 2,
      overflow = TextOverflow.Ellipsis,
      textAlign = TextAlign.End,
      color = colorResource(id = R.color.white),
      fontWeight = FontWeight.Normal,
    )
  }
}
