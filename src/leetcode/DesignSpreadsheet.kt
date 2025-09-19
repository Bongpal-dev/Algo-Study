package leetcode

fun main() {
    val ss = Spreadsheet(3)
    val cmd = listOf("getValue", "setCell", "getValue", "setCell", "getValue", "resetCell", "getValue")
    val data = listOf(
        listOf("=5+7"),
        listOf("A1", "10"),
        listOf("=A1+6"),
        listOf("B2", "15"),
        listOf("=A1+B2"),
        listOf("A1"),
        listOf("=A1+B2")
    )

    cmd.mapIndexed { i, c ->
        when (c) {
            "setCell" -> {
                val (cell, value) = data[i]

                ss.setCell(cell, value.toInt())
                null
            }

            "resetCell" -> {
                ss.resetCell(data[i][0])
                null
            }

            else -> {
                ss.getValue(data[i][0])
            }
        }
    }.run(::println)
}

private class Spreadsheet(rows: Int) {
    val sp = Array(rows) { IntArray(26) }

    fun setCell(cell: String, value: Int) {
        val (row, col) = cell.toIndex()

        sp[row][col] = value
    }

    fun resetCell(cell: String) {
        val (row, col) = cell.toIndex()

        sp[row][col] = 0
    }

    fun getValue(formula: String): Int {
        val split = formula.split("+")
        val (o1, o2) = split[0].drop(1) to split[1]

        return o1.toValue() + o2.toValue()
    }

    private fun String.toIndex(): Pair<Int, Int> {
        val row = this.substring(1).toInt() - 1
        val col = (this[0] - 'A')

        return row to col
    }

    private fun String.toValue(): Int {
        return if (this[0].isLetter()) {
            val (r, c) = this.toIndex()

            sp[r][c]
        } else this.toInt()
    }
}

// https://leetcode.com/problems/design-spreadsheet/description