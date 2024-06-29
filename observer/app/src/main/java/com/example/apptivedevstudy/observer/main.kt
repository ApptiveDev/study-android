package com.example.apptivedevstudy.observer

private fun main() {
    val liveData = MyLiveData("초기값")
    val observer1 = Observer(value = "1", "1번 옵저버")
    val observer2 = Observer(value = "2", "2번 옵저버")
    val observer3 = Observer(value = "3", "3번 옵저버")
    val observer4 = Observer(value = "4", "4번 옵저버")

    liveData.observe(observer1)
    liveData.observe(observer2)
    liveData.observe(observer3)
    liveData.observe(observer4)

    liveData.setValue("변경한 값")
}