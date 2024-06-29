package com.example.apptivedevstudy.observer

interface Observable {
    fun update()
}

class Armor: Observable {
    override fun update() {
        println("방어구가 데미지를 받았습니다!")
    }
}

class Weapon: Observable {
    override fun update() {
        println("무기가 데미지를 받았습니다.")
    }
}
class Subject(private var text: String) {
    private val events = ArrayList<Observable>()

    fun attach(event: Observable) {
        events.add(event)
    }

    fun detach(event: Observable) {
        events.remove(event)
    }

    fun setText(newText: String) {
        text = newText
        notifyObservers()
    }

    private fun notifyObservers() {
        for (event in events) {
            event.update()
        }
    }
}

fun myLambda() {
    println("첫 번째 람다")
    println("첫 번째 람다가 실행되었습니다.")
}

private fun main() {
    val subject = Subject("초기값")
    val armor = Armor()
    val weapon = Weapon()

    subject.attach(armor)
    subject.attach(weapon)

    subject.setText("데미지 1 받음")
    subject.setText("데미지 2 받음")

    subject.detach(armor)
    println("-----------------방어구 깨짐")
    subject.setText("데미지 3 받음")
}