package com.pa1pal.jetsetgo.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.pa1pal.jetsetgo.ButtonsUI
import com.pa1pal.jetsetgo.R
import com.pa1pal.jetsetgo.ui.theme.darkGrey
import com.pa1pal.jetsetgo.ui.theme.grey
import com.pa1pal.jetsetgo.ui.theme.white
import com.pa1pal.jetsetgo.ui.theme.yellow

@Composable
fun CountDownView(
    modifier: Modifier,
    progress: Float,
    time: String
) {
    val font = FontFamily(
        Font(R.font.montserrat_regular, FontWeight.Light)
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
        ,
        contentAlignment = Alignment.Center
    ) {
        JetSetGoCircleAnimation(modifier = modifier.size(140.dp), progress = 1.0f, color = grey)
        JetSetGoCircleAnimation(modifier = modifier.size(140.dp), progress = progress, color = yellow)

        Text(
            modifier = modifier
                .wrapContentWidth()
                .wrapContentHeight(),
            text = time,
            color = white,
            fontSize = 60.sp,
            fontFamily = font,
            style = MaterialTheme.typography.h4
        )
    }
}

@Preview("countdownview", heightDp = 700)
@Composable
fun CountDownViewPreview() {
    LazyColumn(
        modifier = Modifier

            .background(darkGrey),
        verticalArrangement = Arrangement.SpaceEvenly,
        content = {
            item {
                CountDownView(modifier = Modifier.fillMaxWidth(), progress = 1.0f, time = "1000")

            }
            item {
                Spacer(modifier = Modifier.height(40.dp))
            }
        })
}

@Preview("countdownprogress", heightDp = 400)
@Composable
fun CountDownPreview() {
    CountDownView(modifier = Modifier.fillMaxWidth(), progress = 1.0f, time = "1000")
}