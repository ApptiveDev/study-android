package com.example.apptivedevstudy.git

class Calculator: ICalculator<Int> {
    private val history = emptyList<Int>()
    val result get() = history.last()

    init {

    }

    override fun add(a: Int, b: Int): Int {

    }

    override fun subtract(a: Int, b: Int): Int {

    }

    override fun multiply(a: Int, b: Int): Int {

    }

    override fun division(a: Int, b: Int): Int {
        
        var divi = a / b
        history.add(divi)

    }

    fun printResult() {
        println("마지막 계산 결과: $result")
    }
}