package com.example.jetmovies.screens.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.jetmovies.R
import com.example.jetmovies.model.Movie
import com.example.jetmovies.model.getMovies
import com.example.jetmovies.model.getUpComingMovies
import com.example.jetmovies.navigation.MovieScreens
import com.example.jetmovies.ui.theme.MyDarkGrey
import com.example.jetmovies.utils.ScreenConfig
import com.example.jetmovies.widgets.MovieRow
import com.example.jetmovies.widgets.SearchBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var isSearchValidState by remember { mutableStateOf(false) }
    var searchResultState by remember { mutableStateOf(listOf<Movie?>()) }
    var searchTextState by remember { mutableStateOf("") }
    var expanded = remember(searchResultState) { searchResultState.map { false }.toMutableStateList() }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "What do you want to watch?",
                    modifier = Modifier.padding(start = 15.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.smallTopAppBarColors(MyDarkGrey) ,
            )
        },
        containerColor = MyDarkGrey
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxWidth()
            .fillMaxHeight()) {
            MainContent(navController = navController,
                isSearchValidState = isSearchValidState,
                searchTextState = searchTextState,
                updateSearchTextState = {
                  searchTextState = it
                  if(searchTextState.isEmpty()) {
                      isSearchValidState = false
                  }
                },
                expanded = expanded,
                updateExpanded = { index, expand ->
                    expanded[index] = expand
                },
                searchResultState = searchResultState,
            ) { newSearchStatus, newSearchResultList ->
                isSearchValidState = newSearchStatus
                searchResultState = newSearchResultList
            }
            BackHandler(
                enabled = isSearchValidState
            ) {
                if(isSearchValidState) {
                    searchTextState = ""
                    isSearchValidState = false
                }
            }
        }
    }
}

@Composable
fun MainContent(
    navController: NavController,
    isSearchValidState: Boolean,
    searchTextState: String,
    updateSearchTextState: (String)->Unit,
    expanded: List<Boolean>,
    updateExpanded: (Int, Boolean)->Unit,
    searchResultState: List<Movie?>,
    updateSearchResultState: (Boolean, List<Movie?>)->Unit,
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBox(
            searchText = searchTextState,
            onSearchTextValueChange = {
                updateSearchTextState.invoke(it)
            }
        ) {newSearchStatus, newSearchResultList ->
            updateSearchResultState.invoke(newSearchStatus, newSearchResultList)
        }
        Spacer(modifier = Modifier.height(20.dp))
        if(isSearchValidState) DisplaySearchResults(searchResult = searchResultState,
            navController = navController,
            expanded = expanded,
            updateExpanded = { index, expand ->
                updateExpanded.invoke(index, expand)
            }
            )
        else DisplayMoviesSections(navController = navController)
    }
}

@Composable
fun DisplaySearchResults(searchResult: List<Movie?>,
                         navController: NavController,
                         expanded: List<Boolean>,
                         updateExpanded: (Int, Boolean)->Unit) {
    if(searchResult[0] == null) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.search),
                contentDescription = "Movie Not Found",
                modifier = Modifier.height(150.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Sorry!!",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displaySmall,
                color = Color.White)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "We were unable to fetch this movie.. :(",
                modifier = Modifier.width(150.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White)
        }
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(items = searchResult) { movie ->
                if (movie != null) {
                    MovieRow(movie = movie,
                        expanded = expanded[searchResult.indexOf(movie)],
                        onExpandIconClick = {
                            val idx = searchResult.indexOf(movie)
                            updateExpanded.invoke(idx, !expanded[idx])
                        }) { movieId, movieCategory ->
                        navController.navigate(MovieScreens.DetailsScreen.name + "/$movieId/$movieCategory")
                    }
                }
            }
        }
    }
}

@Composable
fun DisplayMoviesSections(
    currentMoviesList: List<Movie> = getMovies(),
    upcomingMoviesList: List<Movie> = getUpComingMovies(),
    navController: NavController
) {
    val screenHeight = ScreenConfig.getHeight()
    val screenWidth = ScreenConfig.getWidth()

    val tabs = listOf("Now Playing", "Upcoming")
    var tabIndex = remember { mutableStateOf(0) }
    var movies = remember { mutableStateOf(0) }

    Text(text = "Top Hits..",
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.titleMedium
    )
    Spacer(modifier = Modifier.height(15.dp))
    Card(
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            items(items = currentMoviesList) {
                Card(
                    modifier = Modifier
                        .height(screenHeight / 4)
                        .width(screenWidth / 3)
                        .clickable {
                            navController.navigate(MovieScreens.DetailsScreen.name + "/${it.id}/${it.category}")
                        },
                    shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                    elevation = CardDefaults.cardElevation(5.dp),
                    border = BorderStroke(width = 2.dp, color = Color.White)
                ) {
                    Image(painter = rememberImagePainter(data = it.profilePoster) ,
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight())
                }
            }
        }
    }
    Spacer(modifier = Modifier.padding(top = 20.dp))
    Column(
    ) {
        TabRow(selectedTabIndex = tabIndex.value,
            modifier = Modifier.padding(horizontal = 15.dp),
            containerColor = MyDarkGrey,
            divider = {},
            indicator = {
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(it[tabIndex.value]),
                    color = Color.White
                )
            }) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex.value == index,
                    onClick = {
                        tabIndex.value = index
                        movies.value = index
                    },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.Gray) {
                    Text(text = title,
                        modifier = Modifier.padding(bottom = 10.dp),
                        style = MaterialTheme.typography.titleMedium)
                }
            }
        }
        LazyVerticalGrid(columns = GridCells.Adaptive(screenWidth/4),
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = if(movies.value == 0) currentMoviesList else upcomingMoviesList) {
                Card(
                    modifier = Modifier
                        .height(screenHeight / 5)
                        .clickable {
                            navController.navigate(MovieScreens.DetailsScreen.name + "/${it.id}/${it.category}")
                        },
                    shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                    elevation = CardDefaults.cardElevation(5.dp),
                    border = BorderStroke(width = 2.dp, color = Color.White)
                ) {
                    Image(painter = rememberImagePainter(data = it.profilePoster) ,
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight())
                }
            }
        }
    }
}
