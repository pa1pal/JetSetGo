package com.pa1pal.jetsetgo.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pa1pal.jetsetgo.R
import com.pa1pal.jetsetgo.ui.theme.darkGrey200
import com.pa1pal.jetsetgo.ui.theme.neon
import com.pa1pal.jetsetgo.ui.theme.white

@Composable
fun CircularButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonText: String,
    backgroundColor: Color,
    textColor: Color
) {
    Button(
        modifier = modifier
            .size(100.dp),
        onClick = onClick,
        border = BorderStroke(1.dp, Color.Black),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor)
    ) {
        Text(
            text = buttonText,
            color = textColor,
            fontFamily = FontFamily(Font(R.font.montserrat_regular, FontWeight.Light))
        )
    }
}

@Composable
fun TimerButtons(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonText: String
) {

    TextButton(
        modifier = modifier.wrapContentWidth(Alignment.CenterHorizontally),
        onClick = onClick,
        border = BorderStroke(1.dp, neon),
        colors = ButtonDefaults.buttonColors(backgroundColor = darkGrey200),
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            modifier = modifier.padding(8.dp), color = white,
            fontFamily = FontFamily(Font(R.font.montserrat_regular, FontWeight.Light)),
            text = buttonText
        )
    }
}