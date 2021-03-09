package com.pa1pal.jetsetgo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pa1pal.jetsetgo.R
import com.pa1pal.jetsetgo.component.CircularButton
import com.pa1pal.jetsetgo.component.CountDownView
import com.pa1pal.jetsetgo.component.TimerButtons
import com.pa1pal.jetsetgo.ui.theme.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = defaultViewModelProviderFactory.create(MainViewModel::class.java)
        setContent {
            MyTheme {
                HomeScreen(mainViewModel)
            }
        }
    }
}

@Composable
fun HomeScreen(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(darkGrey),
        verticalArrangement = Arrangement.SpaceEvenly,
        content = {
            item {
                CountDownView(
                    modifier = modifier
                        .fillMaxWidth(),
                    progress = viewModel.progress,
                    time = viewModel.minutes + ":" + viewModel.seconds
                )
            }
            item {
                Spacer(modifier = modifier.height(40.dp))
            }
            item {
                ButtonsUI(
                    modifier = modifier,
                    onStartClick = viewModel::changeTimerState,
                    onStopClick = viewModel::stopAndResetTimer,
                    onAddSecondsClick = viewModel::onAddSeconds,
                    onSubtractSecondsClick = viewModel::onSubtractSeconds,
                    timerState = viewModel.timerState,
                    progress = viewModel.progress
                )
            }
        })
}

@Composable
fun StartButton(onStartClick: () -> Unit, buttonText: String) {
    CircularButton(
        onClick = onStartClick, buttonText = buttonText, backgroundColor = green,
        textColor = neon
    )
}

@Composable
fun StopButton(onStopClick: () -> Unit) {
    CircularButton(
        onClick = onStopClick, buttonText = stringResource(id = R.string.stop),
        backgroundColor = darkGrey200,
        textColor = white
    )
}

@Composable
fun ButtonsUI(
    modifier: Modifier,
    onStartClick: () -> Unit,
    onStopClick: () -> Unit,
    onAddSecondsClick: () -> Unit,
    onSubtractSecondsClick: () -> Unit,
    timerState: TimerState,
    progress: Float
) {
    Column(
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .fillMaxWidth()
        ) {

            val buttonText = if (timerState == TimerState.TIMER_RUNNING) {
                stringResource(id = R.string.pause)
            } else {
                if (progress < 1.0f) {
                    stringResource(id = R.string.resume)
                } else {
                    stringResource(id = R.string.start)
                }
            }
            StopButton(onStopClick = onStopClick)
            StartButton(onStartClick = onStartClick, buttonText)
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {

            TimerButtons(
                onClick = onSubtractSecondsClick,
                buttonText = stringResource(id = R.string.sub15)
            )
            TimerButtons(
                onClick = onAddSecondsClick,
                buttonText = stringResource(id = R.string.add15)
            )
        }
    }
}
