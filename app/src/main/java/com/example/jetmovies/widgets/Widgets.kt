package com.example.jetmovies.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.jetmovies.model.Movie
import com.example.jetmovies.model.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0],
             expanded: Boolean = false,
             onExpandIconClick: ()->Unit = {},
             onItemClick: (String)->Unit = {}) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(movie.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Surface(
                modifier = Modifier.size(100.dp),
                shape = CircleShape,
                shadowElevation = 10.dp,
            ) {
                Image(painter = rememberImagePainter(data = movie.images[0],
                    builder = {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }),
                    contentDescription = "image for movie")
            }
            Column() {
                Text(text = movie.title,
                    style = MaterialTheme.typography.titleLarge)
                Text(text = "Director: ${movie.director}",
                    style = MaterialTheme.typography.bodyMedium)
                Text(text = "Released: ${movie.year}",
                    style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(5.dp))

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text( buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 14.sp)) {
                                append("Plot: ")
                            }
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Light)) {
                                append(movie.plot)
                            }
                        },
                            modifier = Modifier.padding(5.dp))
                        Divider(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(fontSize = 14.sp, color = Color.DarkGray)) {append("Actors: ")}
                            withStyle(style = SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Light)) {append(movie.actors)}
                        })
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(fontSize = 14.sp, color = Color.DarkGray)) {append("Rating: ")}
                            withStyle(style = SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Light)) {append(movie.rating)}
                        })
                    }
                }

                Icon(imageVector = if(expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown, contentDescription = "KeyBoard Arrow",
                    modifier = Modifier.clickable {
                        onExpandIconClick()
                    })
            }
        }
    }
}