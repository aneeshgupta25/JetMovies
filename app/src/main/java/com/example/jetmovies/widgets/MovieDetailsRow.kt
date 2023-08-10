package com.example.jetmovies.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
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
             onItemClick: (String, Int)->Unit = { id: String, category: Int -> }) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(movie.id, movie.category)
            },
        colors = CardDefaults.cardColors(Color(0xFF3A3F47)),
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
            Card(
                modifier = Modifier.height(screenHeight / 5)
                    .width(screenWidth / 4),
            ) {
                Image(painter = rememberImagePainter(data = movie.profilePoster,
                    builder = {
                        crossfade(true)
                    }),
                    modifier = Modifier.fillMaxHeight().fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                    contentDescription = "image for movie")
            }
            Column() {
                Text(text = movie.title,
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge)
                Text(text = "Director: ${movie.director}",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(top = 5.dp)
                ){
                    Icon(imageVector = Icons.Outlined.CalendarToday, contentDescription = "Date",
                        tint = Color.White)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "${movie.date}",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium)
                }
                Spacer(modifier = Modifier.height(5.dp))

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text( buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.White, fontSize = 14.sp)) {
                                append("Plot: ")
                            }
                            withStyle(style = SpanStyle(color = Color.White, fontWeight = FontWeight.Light)) {
                                append(movie.plot)
                            }
                        },
                            modifier = Modifier.padding(5.dp))
                        Divider(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(fontSize = 14.sp, color = Color.White)) {append("Actors: ")}
                            withStyle(style = SpanStyle(fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Light)) {append(movie.actors)}
                        })
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(fontSize = 14.sp, color = Color.White)) {append("Rating: ")}
                            withStyle(style = SpanStyle(fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Light)) {append(movie.rating)}
                        })
                    }
                }

                Icon(imageVector = if(expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown, contentDescription = "KeyBoard Arrow",
                    modifier = Modifier.clickable {
                        onExpandIconClick()
                    },
                    tint = Color.White)
            }
        }
    }
}