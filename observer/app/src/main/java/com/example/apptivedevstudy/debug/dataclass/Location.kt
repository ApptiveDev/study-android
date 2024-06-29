package com.example.apptivedevstudy.debug.dataclass

data class Location(val row: Int, val column: Int) {
    override fun toString(): String {
        return "($row, $column)"
    }
}
