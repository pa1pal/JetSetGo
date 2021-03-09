package com.pa1pal.jetsetgo.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun JetSetGoCircleAnimation(
    modifier: Modifier = Modifier,
    progress: Float,
    color: Color
) {
    CircularProgressIndicator(
        modifier = modifier,
        progress = progress,
        color = color,
        strokeWidth = 8.dp
    )
}