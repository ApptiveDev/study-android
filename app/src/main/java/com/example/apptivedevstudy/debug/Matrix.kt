package com.example.apptivedevstudy.debug

import com.example.apptivedevstudy.debug.dataclass.Location
import com.example.apptivedevstudy.debug.dataclass.Size
import com.example.apptivedevstudy.debug.enums.Tile

class Matrix(private val rows: MutableList<Row>) {
    val value: List<Row> get() = rows
    val size: Size
        get() {
        return Size(
            width = value[0].size,
            height = value.size
        )
    }
    val blanks: List<Location> get() {
        return locations().filter { get(it) == Tile.Blank }
    }

    fun get(loc: Location): Tile {
        val row = rows[loc.row]
        return row.values[loc.column]
    }

    fun set(loc: Location, tile: Tile) {
        rows[loc.row].values[loc.column] = tile
    }

    fun virusLocations(): List<Location> {
        val locations = mutableListOf<Location>()

        for (idxRow in 0 until rows.size) {
            val row = rows[idxRow]
            for (idxCol in 0 until row.size) {
                val tile = row[idxCol]
                if (tile == Tile.Virus)
                    locations.add(Location(idxRow, idxCol))
            }
        }

        return locations
    }

    fun append(row: Row) { rows.add(row) }

    fun isValid(loc: Location): Boolean {
        return (loc.row in 0 until size.height) &&
                (loc.column in 0 until size.width)
    }

    fun copy(): Matrix {
        return Matrix(rows.map { it.copy() }.toMutableList())
    }

    fun print() {
        for (row in rows) {
            println(row)
        }
    }

    private fun locations(): List<Location> {
        val list = mutableListOf<Location>()
        for (rowIdx in 0 until size.height)
            for (colIdx in 0 until size.width)
                list.add(Location(rowIdx, colIdx))

        return list
    }
}