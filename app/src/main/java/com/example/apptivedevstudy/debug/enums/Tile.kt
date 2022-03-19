package com.example.apptivedevstudy.debug.enums

enum class Tile(val value: Int) {
    Blank(0), Wall(1), Virus(2);

    companion object {
        fun of(text: String): Tile {
            return values().first { it.value == text.toInt() }
        }
    }
}