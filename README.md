# RickAndMorty

This is a simple Android application that retrieves and displays information about the characters from the popular TV show "Rick and Morty". The application fetches character data from the Rick and Morty API (https://rickandmortyapi.com/).

## Features

#### 1. Starring
You can give star to the character of your choice in Character Details Screen. The star will be visible on the character item of the list. You can use the filter "Starred" to get all the characters you have given star to.

#### 2. Filtering
You can filter the list of characters on various filters available in the app like - "Starred, Alive, Dead, Male, Female". These filters can be applied in any order and in any possible combination. The list of the characters will then be filtered according these filters and only the filtered data is shown to the user.

#### 3. Searching
You can search for a character by their name. The text in SearchInputField looks for the occurence of the substring in the names of characters and return the modified list.

#### 4.Pagination
The character list is paginated. Each page contains 20 characters. API call for next page is made only when user reaches to the end of the list.

#### 5. Animations
You can find cool animations for the character info and character image in Character Details Screen. Animations such as fadeIn(), slideIn() are used.

## Tech Stack
1. Kotlin
2. JetPack Compose
3. Hilt
4. Compose Navigation
5. MVVM
6. Retrofit
7. Coil

## ScreenShots

<p align="center">
  <img  width="300" height="600" src = "https://github.com/buddha-buktare/RickAndMorty/assets/128225158/2cc01228-8355-4445-ac3a-3874193abd34" /> 
  <img  width="300" height="600" src = "https://github.com/buddha-buktare/RickAndMorty/assets/128225158/df223c10-6794-4623-85ed-5582303e81bb" />
</p>

