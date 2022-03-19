package com.example.apptivedevstudy.debug

class Combinator<T>(private val list: List<T>) {
    private val combinations = mutableListOf<List<T>>()

    fun getCombinations(size: Int): List<List<T>> {
        calculate(mutableListOf(), 0, size)
        return combinations
    }

    /** 백트래킹으로 모든 조합을 구한다. */
    private fun calculate(chosen: MutableList<T>, start: Int, targetSize: Int) {
        // 탈출조건: 마지막 원소만 남았을 때
        val sizeLeft = targetSize - chosen.size
        if (sizeLeft <= 1) {
            chosen.add(list[start])
            combinations.add(chosen)
            return
        }

        // 백트래킹
        val idxLimit = list.size - sizeLeft
        for (idx in start..idxLimit) {
            chosen.add(list[idx])
            calculate(chosen.toMutableList(), idx+1, targetSize)
            chosen.remove(list[idx])
        }
    }
}