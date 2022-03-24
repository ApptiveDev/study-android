package com.example.apptivedevstudy.git

class Calculator: ICalculator<Int> {
    private val history = emptyList<Int>()
    val result get() = history.last()

    init {

    }

    override fun add(a: Int, b: Int): Int {
        return a+b
    }

    override fun subtract(a: Int, b: Int): Int {

    }

    override fun multiply(a: Int, b: Int): Int {

    }

    override fun divide(a: Int, b: Int): Int {
        return a / b
    }

    fun printResult() {
        println("마지막 계산 결과: $result")
    }
}