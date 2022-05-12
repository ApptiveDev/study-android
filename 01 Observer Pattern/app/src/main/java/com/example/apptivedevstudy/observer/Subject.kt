package com.example.apptivedevstudy.observer

class MyLiveData<T>(
    private var data: T
) {
    val events = ArrayList<LiveDataObserver<T>>()

    fun observe(event: LiveDataObserver<T>) {
        events.add(event)
    }

    fun setValue(newData: T) {
        data = newData
        notifyObservers()
    }

    private fun notifyObservers() {
        for (event in events) {
            event.update(data)
        }
    }
}