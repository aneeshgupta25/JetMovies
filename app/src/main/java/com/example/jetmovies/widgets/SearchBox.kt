package com.example.jetmovies.widgets

import android.util.Log
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetmovies.model.Movie
import com.example.jetmovies.model.getMovies
import com.example.jetmovies.ui.theme.MyLightGrey

val movies = getMovies()

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(updateSearchStatus: (searchList: List<Movie?>)->Unit = {}) {
    var textState by remember { mutableStateOf("") }
    Card(
        colors = CardDefaults.cardColors(Color(0xFF3A3F47)),
        shape = CircleShape.copy(CornerSize(20.dp))
    ) {
        TextField(
            value = textState,
            onValueChange = { textState = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search",
                color = MyLightGrey) },
            trailingIcon = {
                if (textState.isEmpty())
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search",
                    tint = MyLightGrey)
                else
                    Icon(imageVector = Icons.Default.Cancel, contentDescription = "Cancel Search",
                    modifier = Modifier.clickable {
                        textState = ""
                        updateSearchStatus(listOf())
                    },
                    tint = MyLightGrey)
            },
            keyboardActions = KeyboardActions {
                val searchList = updateSearchList(textState)
                Log.d("Aneesh", searchList.toString())
                updateSearchStatus(searchList)
            },
            keyboardOptions = KeyboardOptions(
                imeAction = if(textState.isNotEmpty()) ImeAction.Next else ImeAction.Default
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

fun updateSearchList(userInput: String?): List<Movie?> {
    if(userInput == "") return listOf()

     var list =  movies.filter {
        it.title.toLowerCase().startsWith(userInput!!.toLowerCase())
    }
    if(list.isNotEmpty()) return list
    return listOf(null)
}