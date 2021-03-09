package com.pa1pal.jetsetgo

import android.os.CountDownTimer
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.concurrent.TimeUnit

/**
 * default state of timer is one minute, with increase decrease of 15 sec
 */
private const val ONE_MINUTE = 60000L
private const val TIMER_FORMAT = "%02d"

class MainViewModel: ViewModel(), MainNavigator {
    var timerValue by mutableStateOf(ONE_MINUTE)
    var progress by mutableStateOf(1.00F)
    var minutes by mutableStateOf(String.format(TIMER_FORMAT, 1))
    var seconds by mutableStateOf(String.format(TIMER_FORMAT, 0))
    var timerState by mutableStateOf(TimerState.TIMER_PAUSED)
    private var countDownTimer: CountDownTimer? = null

    override fun changeTimerState() {
        if (timerState == TimerState.TIMER_PAUSED) {
            startTimer()
        } else {
            pauseTimer()
        }
    }

    override fun startTimer() {
        timerState = TimerState.TIMER_RUNNING
        countDownTimer = object : CountDownTimer(timerValue, 1) {
            override fun onTick(millisRemaining: Long) {
                timerState = TimerState.TIMER_RUNNING
                timerValue = millisRemaining
                setTimeInMinutes()
                val progressValue = millisRemaining.toFloat() / ONE_MINUTE
                progress = String.format("%1.2f", progressValue).toFloat()
            }

            override fun onFinish() {
                timerState = TimerState.TIMER_STOP
                stopAndResetTimer()
            }
        }.start()
    }

    override fun pauseTimer() {
        if (countDownTimer != null) {
            timerState = TimerState.TIMER_PAUSED
            countDownTimer?.cancel()
        }
    }

    override fun stopAndResetTimer() {
        if (countDownTimer != null) {
            timerState = TimerState.TIMER_STOP
            countDownTimer?.cancel()
            progress = 1.0f
            timerValue = ONE_MINUTE
            setTimeInMinutes()
        }
    }

    override fun onAddSeconds() {
        timerValue += 15000
        setTimeInMinutes()
    }

    override fun onSubtractSeconds() {
        if (timerValue != 0L) {
            timerValue -= 15000
            setTimeInMinutes()
        }
    }

    fun setTimeInMinutes() {
        minutes = String.format(
                TIMER_FORMAT,
                TimeUnit.MILLISECONDS.toMinutes(timerValue))

        seconds = String.format(
                TIMER_FORMAT,
                TimeUnit.MILLISECONDS.toSeconds(timerValue) % 60
        )
    }
}

enum class TimerState {
    TIMER_PAUSED, TIMER_RUNNING, TIMER_STOP
}