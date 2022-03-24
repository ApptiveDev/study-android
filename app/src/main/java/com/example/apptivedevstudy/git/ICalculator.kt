package com.example.apptivedevstudy.git

interface ICalculator<T> {
    fun add(a: T, b: T): T
    fun subtract(a: T, b: T): T
    fun multiply(a: T, b: T): T
    fun divide(a: T, b: T): T
}