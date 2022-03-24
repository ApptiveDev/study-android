package com.example.apptivedevstudy.debug

import com.example.apptivedevstudy.debug.dataclass.Location
import com.example.apptivedevstudy.debug.enums.Tile
import java.util.*

fun getMatrix(): Matrix {
    val size = readLine()!!.split(" ").map { it.toInt() }
    val rowSize = size[0]

    val rows = mutableListOf<Row>()
    for (i in 1..rowSize) {
        val row = Row(readLine()!!)
        rows.add(row)
    }

    return Matrix(rows)
}

/* BFS를 통해 바이러스를 퍼뜨린다. */
fun spreadVirus(matrix: Matrix): Matrix {
    val newMatrix = matrix.copy()
    val viruses = matrix.virusLocations()
    val visited: MutableSet<Location> = HashSet(viruses)
    val queue: Queue<Location> = LinkedList(viruses)

    while (queue.isNotEmpty()) {
        val curLocation = queue.poll()!!
        val curTile = newMatrix.get(curLocation)
        // 현재 타일이 벽이면 확산 불가
        if (curTile == Tile.Wall) continue
        // 빈 곳이면 바이러스 확산
        if (curTile == Tile.Blank) newMatrix.set(curLocation, Tile.Virus)

        // 다음에 방문할 Queue에 추가
        val up = curLocation.copy(row = curLocation.row + 1)
        val down = curLocation.copy(row = curLocation.row - 1)
        val left = curLocation.copy(column = curLocation.column - 1)
        val right = curLocation.copy(column = curLocation.column + 1)

        for (newLoc in listOf(up, down, left, right)) {
            if (newMatrix.isValid(newLoc) && !visited.contains(newLoc)) {
                visited.add(newLoc)
                queue.add(newLoc)
            }
        }
    }

    return newMatrix
}

/** 가장 안전한 벽 조합을 고른다. */
fun getSafestComb(matrix: Matrix, combinator: Combinator<Location>): List<Location> {
    val combs = combinator.getCombinations(3)
    var safestCount = -1
    var safestComb = listOf<Location>()

    for (comb in combs) {
        val newMatrix = matrix.copy()
        for (loc in comb) newMatrix.set(loc, Tile.Wall)

        val spreaded = spreadVirus(newMatrix)
        val count = spreaded.blanks.size
        if (count > safestCount) {
            safestCount = count
            safestComb = comb
        }
    }

    return safestComb
}

fun main() {
    val matrix = getMatrix()
    val combinator = Combinator(matrix.blanks)
    val safest = getSafestComb(matrix, combinator)
    for (loc in safest) matrix.set(loc, Tile.Wall)
    val spreaded = spreadVirus(matrix)

    println("----------------- 가장 안전한 벽 위치")
    println(safest)

    println()

    println("----------------- 벽을 세운 후 행렬")
    matrix.print()

    println()

    println("----------------- 바이러스를 퍼뜨린 후 행렬")
    spreaded.print()

    println()

    println("----------------- 안전영역 수")
    println("${spreaded.blanks.size} 개")
}

// 테스트 케이스
//7 7
//2 0 0 0 1 1 0
//0 0 1 0 1 2 0
//0 1 1 0 1 0 0
//0 1 0 0 0 0 0
//0 0 0 0 0 1 1
//0 1 0 0 0 0 0
//0 1 0 0 0 0 0

//4 6
//0 0 0 0 0 0
//1 0 0 0 0 2
//1 1 1 0 0 2
//0 0 0 1 0 2