package com.example.apptivedevstudy.git

class Calculator: ICalculator<Int> {
    private val history = emptyList<Int>()
    val result get() = history.last()

    init {
        println("계산기 인스턴스 생성")
    }

    override fun add(a: Int, b: Int): Int {

    }

    override fun subtract(a: Int, b: Int): Int {

    }

    override fun multiply(a: Int, b: Int): Int {

    }

    fun printResult() {
        println("마지막 계산 결과: $result")
    }
}