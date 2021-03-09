package com.pa1pal.jetsetgo.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.pa1pal.jetsetgo.R
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

    ConstraintLayout(modifier) {
        val (progressBar, text) = createRefs()

        Box(
            modifier = modifier
                .fillMaxSize()
                .constrainAs(progressBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentAlignment = Alignment.CenterStart
        ) {
            JetSetGoCircleAnimation(progress = 1.0f, color = grey)
            JetSetGoCircleAnimation(progress = progress, color = yellow)

            Text(
                modifier = modifier
                    .fillMaxSize(),
                text = time,
                textAlign = TextAlign.Center,
                color = white,
                fontSize = 70.sp,
                fontFamily = font,
                style = MaterialTheme.typography.h4
            )
        }
    }
}