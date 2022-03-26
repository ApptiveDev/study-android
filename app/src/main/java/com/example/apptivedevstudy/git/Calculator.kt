package com.example.apptivedevstudy.git

class Calculator: ICalculator<Int> {
    private val history = mutableListOf<Int>()
    val result get() = history.last()

    init {
        println("계산기 인스턴스 생성")
    }

    override fun add(a: Int, b: Int): Int {
        return a+b
    }

    override fun subtract(a: Int, b: Int): Int {
        return a-b
    }

    override fun multiply(a: Int, b: Int): Int {
        return a*b
    }

    override fun division(a: Int, b: Int): Int {
        
        var divi = a / b
        history.add(divi)
        return divi
    }

    fun printResult() {
        println("마지막 계산 결과: $result")
    }
}