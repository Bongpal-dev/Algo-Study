package leetcode

fun main() {
    val case1 = Case(
        m = 4,
        n = 6,
        guards = arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 3)),
        walls = arrayOf(intArrayOf(0, 1), intArrayOf(2, 2), intArrayOf(1, 4)),
    )
    val case2 = Case(
        m = 3,
        n = 3,
        guards = arrayOf(intArrayOf(1, 1)),
        walls = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(2, 1), intArrayOf(1, 2)),
    )

    case1.result(::countUnguarded)
    case2.result(::countUnguarded)
}

private fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
    var ans = m * n
    val map = Array(m) { IntArray(n) }
    val dir = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1),
    )

    for ((y, x) in guards) {
        map[y][x] = 2
        ans--
    }

    for ((y, x) in walls) {
        map[y][x] = -1
        ans--
    }

    for ((y, x) in guards) {
        for ((ya, xa) in dir) {
            var ny = y + ya
            var nx = x + xa

            while (ny in 0..m - 1 && nx in 0..n - 1) {
                val current = map[ny][nx]

                if (current == 2 || current == -1) break

                if (map[ny][nx] == 0) {
                    map[ny][nx] = 1
                    ans--
                }
                ny += ya
                nx += xa
            }
        }
    }

    return ans
}

private data class Case(
    val m: Int,
    val n: Int,
    val guards: Array<IntArray>,
    val walls: Array<IntArray>
) {
    fun result(f: (Int, Int, Array<IntArray>, Array<IntArray>) -> Int) {
        println(f(m, n, guards, walls))
    }
}

// https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/