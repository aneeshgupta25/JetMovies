package com.example.jetmovies.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.jetmovies.ui.theme.MyDarkGrey

@Composable
fun MovieMetadata(
    icon: ImageVector,
    data: String
) {
    Card(
        colors = CardDefaults.cardColors(MyDarkGrey)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier
                .padding(5.dp)
        ) {
            Icon(imageVector = icon, contentDescription = "",
                tint = Color(0xFF92929D)
            )
            Text(data, color = Color(0xFF92929D),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}