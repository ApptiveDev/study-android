package com.example.apptivedevstudy.debug

class Row(var values: MutableList<Tile> = mutableListOf()) {
    val size: Int get() = values.size

    constructor(rowText: String) : this() {
        values = rowText
            .split(" ")
            .map { Tile.of(it) }
            .toMutableList()
    }

    fun copy(): Row {
        return Row(values.toMutableList())
    }

    operator fun get(idx: Int): Tile {
        return values[idx]
    }


    override fun toString(): String {
        return values.map { it.value }
            .toString()
            .replace("[", "")
            .replace("]", "")
            .replace(",", "")
    }
}