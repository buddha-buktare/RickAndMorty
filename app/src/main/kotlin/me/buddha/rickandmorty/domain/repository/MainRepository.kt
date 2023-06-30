package me.buddha.rickandmorty.domain.repository

import me.buddha.rickandmorty.data.network.service.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
  val service: ApiService
) {

}