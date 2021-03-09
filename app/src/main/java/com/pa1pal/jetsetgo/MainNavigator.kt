package com.pa1pal.jetsetgo

interface MainNavigator {
    fun changeTimerState()
    fun startTimer()
    fun pauseTimer()
    fun stopAndResetTimer()
    fun onAddSeconds()
    fun onSubtractSeconds()
}