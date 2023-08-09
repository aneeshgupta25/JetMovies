package com.example.jetmovies.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox() {
    Card(
        colors = CardDefaults.cardColors(Color(0xFF3A3F47)),
        shape = CircleShape.copy(CornerSize(20.dp))
    ) {
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search",
                color = Color(0xFF79797E)) },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search",
                    tint = Color(0xFF79797E))
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF79797E),
                cursorColor = Color(0xFF79797E),
                containerColor = Color(0xFF3A3F47),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}