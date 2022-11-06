package com.example.coroutineflowtest.CountDown

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

fun countDownFlow() = flow<Int> {
    for (i in 9 downTo 0){
        delay(1000L)
        emit(i)
    }
}
