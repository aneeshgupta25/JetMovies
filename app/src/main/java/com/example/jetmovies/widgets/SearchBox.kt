package com.example.jetmovies.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.jetmovies.model.Movie
import com.example.jetmovies.model.getMovies
import com.example.jetmovies.model.getUpComingMovies
import com.example.jetmovies.ui.theme.MyLightGrey
import java.util.Collections

val movies = getMovies()
val upcomingMovies = getUpComingMovies()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(
    searchText: String,
    onSearchTextValueChange: (String)->Unit,
    updateSearchResult: (Boolean, List<Movie?>)->Unit
) {
    Card(
        colors = CardDefaults.cardColors(Color(0xFF3A3F47)),
        shape = CircleShape.copy(CornerSize(20.dp))
    ) {
        TextField(
            value = searchText,
            onValueChange = { onSearchTextValueChange.invoke(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search",
                color = MyLightGrey) },
            trailingIcon = {
                if (searchText.isEmpty())
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search",
                    tint = MyLightGrey)
                else
                    Icon(imageVector = Icons.Default.Cancel, contentDescription = "Cancel Search",
                    modifier = Modifier.clickable {
                        onSearchTextValueChange.invoke("")
//                        updateSearchStatus(listOf())
                    },
                    tint = MyLightGrey)
            },
            keyboardActions = KeyboardActions {
                if(searchText.isEmpty()) updateSearchResult.invoke(false, listOf())
                else {
                    val searchList = getMoviesFromSearch(searchText)
                    updateSearchResult.invoke(true, searchList)
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = if(searchText.isNotEmpty()) ImeAction.Next else ImeAction.Default
            ),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                cursorColor = Color.White,
                containerColor = Color(0xFF3A3F47),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

fun getMoviesFromSearch(userInput: String?): List<Movie?> {

     var currMovieList =  movies.filter {
        it.title.toLowerCase().startsWith(userInput!!.toLowerCase())
    }
    var upcomingMovieList = upcomingMovies.filter {
        it.title.toLowerCase().startsWith(userInput!!.toLowerCase())
    }
    var mutableList = mutableListOf<Movie>()
    currMovieList.forEach { mutableList.add(it) }
    upcomingMovieList.forEach { mutableList.add(it) }

    val list = Collections.unmodifiableList(mutableList)

    if(list.isNotEmpty()) return list
    return listOf(null)
}