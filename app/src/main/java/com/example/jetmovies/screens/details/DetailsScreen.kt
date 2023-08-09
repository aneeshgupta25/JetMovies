package com.example.jetmovies.screens.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.LocalActivity
import androidx.compose.material.icons.outlined.WatchLater
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.jetmovies.R
import com.example.jetmovies.ui.theme.MyDarkGreen
import com.example.jetmovies.ui.theme.MyDarkGrey
import com.example.jetmovies.widgets.MovieMetadata

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DetailsScreen(movieData: String? = "Aneesh") {
//fun DetailsScreen(navController: NavController, movieData: String?) {

    var tabIndex by remember {
        mutableStateOf(0)
    }
    val tabs = listOf("About Movie", "Cast")

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detail",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .fillMaxWidth(),
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center) },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "To navigate Back",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {

                            },
                        tint = Color.White
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(MyDarkGrey) ,
            )
        },
        containerColor = MyDarkGrey
    ) {
        Box(modifier = Modifier
            .padding(it)) {
            Column {
                Box(
                    modifier = Modifier.height((screenHeight/3) + (screenHeight/16))
                ) {
                    CoverAndMovieImage()
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp)
                        .height(30.dp)
                ) {
                    MovieMetadata(icon = Icons.Outlined.CalendarToday, data = "2021")
                    Divider(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                    MovieMetadata(icon = Icons.Outlined.WatchLater, data = "148 minutes")
                    Divider(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                    MovieMetadata(icon = Icons.Outlined.LocalActivity, data = "Action")
                }
                TabRow(selectedTabIndex = tabIndex,
                    modifier = Modifier.padding(horizontal = 25.dp),
                    containerColor = MyDarkGrey,
                    contentColor = MyDarkGrey,
                    divider = {},
                    indicator = {
                        TabRowDefaults.Indicator(
                            Modifier.tabIndicatorOffset(it[tabIndex]),
                            color = Color.White
                        )
                    }
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = tabIndex == index,
                            onClick = {
                                tabIndex = index
                            },
                            selectedContentColor = Color.White,
                            unselectedContentColor = Color.Gray
                        ) {
                            Text(text = title,
                                modifier = Modifier.padding(10.dp),
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
                Box(modifier = Modifier.padding(25.dp)) {
                    if(tabIndex == 0) {
                        Text(text = "Hello World",
                            modifier = Modifier.verticalScroll(rememberScrollState()),
                            style = MaterialTheme.typography.labelLarge,
                            color = Color.White)
                    } else {
                        TODO("Actors...")
                    }
                }
            }
        }
    }
    //navController.popBackStack() -> to go back to previous screen
}

@Composable
fun CoverAndMovieImage() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    ConstraintLayout(
        modifier = Modifier
            .height(screenHeight / 3)
            .fillMaxWidth()
    ) {
        val (coverImageCard, profileImageCard, rating, title) = createRefs()

        Card (
            modifier = Modifier
                .constrainAs(coverImageCard) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 18.dp, bottomEnd = 18.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.demo2), contentDescription = "Image",
            )
        }
        
        Card(
            modifier = Modifier.constrainAs(profileImageCard) {
                top.linkTo(coverImageCard.bottom, margin = (-screenHeight/16*2))
                start.linkTo(coverImageCard.start, margin = (screenWidth/20))
                end.linkTo(coverImageCard.end, margin = (screenWidth/10*6))
                bottom.linkTo(coverImageCard.bottom, margin = (-screenHeight/16*2))
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            },
            border = BorderStroke(width = 2.dp, color = Color.White)
        ) {
            Image(painter = painterResource(id = R.drawable.demo), contentDescription = "",
                contentScale = ContentScale.FillBounds)
        }

        Text(text = "Spiderman No Way Home",
            modifier = Modifier.constrainAs(title) {
                top.linkTo(coverImageCard.bottom, margin = 15.dp)
                start.linkTo(profileImageCard.end, margin = 10.dp)
                end.linkTo(parent.end, margin = 10.dp)

                width = Dimension.fillToConstraints
            },
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White)

        Card(
            modifier = Modifier
                .constrainAs(rating) {
                    top.linkTo(coverImageCard.bottom, margin = (-45).dp)
                    bottom.linkTo(coverImageCard.bottom, margin = 10.dp)
                    end.linkTo(coverImageCard.end, margin = 10.dp)
                    start.linkTo(coverImageCard.end, margin = (-90).dp)

                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
            shape = RoundedCornerShape(corner = CornerSize(18.dp)),
            elevation = CardDefaults.cardElevation(30.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 5.dp)
            ) {
                Icon(imageVector = Icons.Filled.Star, contentDescription = "Rating",
                    tint = MyDarkGreen)
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "9.5",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MyDarkGreen)
            }
        }
    }
}