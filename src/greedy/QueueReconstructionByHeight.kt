package greedy

fun main() {
    val people1 = arrayOf(
        intArrayOf(7, 0),
        intArrayOf(4, 4),
        intArrayOf(7, 1),
        intArrayOf(5, 0),
        intArrayOf(6, 1),
        intArrayOf(5, 2),
    )
    val people2 = arrayOf(
        intArrayOf(6, 0),
        intArrayOf(5, 0),
        intArrayOf(4, 0),
        intArrayOf(3, 2),
        intArrayOf(2, 2),
        intArrayOf(1, 4),
    )

    println(reconstructQueue(people1).joinToString() { it.joinToString() })
    println(reconstructQueue(people2).joinToString() { it.joinToString() })
}

private fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    val answer = mutableListOf<IntArray>()

    people.sortedWith(
        Comparator { o1, o2 ->
            if (o1.first() == o2.first()) return@Comparator compareValues(o1.last(), o2.last())

            return@Comparator compareValues(o2.first(), o1.first())
        }
    ).forEach { answer.add(it.last(), it) }

    return answer.toTypedArray()
}

// https://leetcode.com/problems/queue-reconstruction-by-height/description/