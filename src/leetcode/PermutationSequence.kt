package leetcode

fun main() {
    val (n1, k1) = 3 to 3
    val (n2, k2) = 4 to 9
    val (n3, k3) = 3 to 1

    println(getPermutation(n1, k1))
    println(getPermutation(n2, k2))
    println(getPermutation(n3, k3))
}

private fun getPermutation(n: Int, k: Int): String {
    val sb = StringBuilder()
    val nums = MutableList(n) { it + 1 }
    val fact = nums.runningFold(1) { acc, v -> acc * v }.reversed().drop(1)
    var r = k - 1

    for (f in fact) {
        val i = r / f

        r %= f
        sb.append(nums.removeAt(i))
    }

    return sb.toString()
}

// https://leetcode.com/problems/permutation-sequence/description/