package leetcode

fun main() {
    val (n1, n2) = listOf(2, 3)
    val (languages1, languages2) = listOf(
        arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(1, 2)),
        arrayOf(intArrayOf(2), intArrayOf(1, 3), intArrayOf(1, 2), intArrayOf(3))
    )
    val (friendships1, friendships2) = listOf(
        arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 3)),
        arrayOf(intArrayOf(1, 4), intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(2, 3))
    )

    println(minimumTeachings(n1, languages1, friendships1))
    println(minimumTeachings(n2, languages2, friendships2))
}

private fun minimumTeachings(n: Int, languages: Array<IntArray>, friendships: Array<IntArray>): Int {
    val l = List(n + 1) { hashSetOf<Int>() }
    val c = hashSetOf<Int>()

    languages.forEachIndexed { i, v ->
        v.forEach { l[it].add(i) }
    }

    friendships.forEach { f ->
        val a = f[0] - 1
        val b = f[1] - 1

        if (languages[a].none { b in l[it] }) {
            c += a
            c += b
        }
    }

    return if (c.isEmpty()) 0 else (1..n).minOf { ln -> c.count { it !in l[ln] } }
}

// https://leetcode.com/problems/minimum-number-of-people-to-teach/description