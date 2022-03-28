package com.example.apptivedevstudy.observer

import androidx.lifecycle.LiveData

interface LiveDataObserver<T> {
    fun update(data: T)
}

class Observer<T>(var value: T, val name: String): LiveDataObserver<T> {
    override fun update(data: T) {
        value = data
        println("${name}의 값이 수정되었습니다! ")
    }
}