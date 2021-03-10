package com.pa1pal.jetsetgo.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun JetSetGoCircleAnimation(
    modifier: Modifier = Modifier,
    progress: Float,
    color: Color
) {
    val pxValue = with(LocalDensity.current) { 150.dp }
    val height = LocalConfiguration.current.screenWidthDp

    CircularProgressIndicator(
        modifier = modifier.padding(bottom = height.div(2).dp),
        progress = progress,
        color = color,
        strokeWidth = 8.dp
    )
}