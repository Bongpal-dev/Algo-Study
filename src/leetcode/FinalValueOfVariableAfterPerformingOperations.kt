package leetcode

fun main() {
    val operations1 = arrayOf("--X","X++","X++")
    val operations2 = arrayOf("++X","++X","X++")
    val operations3 = arrayOf("X++","++X","--X","X--")

    println(finalValueAfterOperations(operations1))
    println(finalValueAfterOperations(operations2))
    println(finalValueAfterOperations(operations3))
}

private fun finalValueAfterOperations(operations: Array<String>): Int {
    var ans = 0

    operations.forEach {
        when(it) {
            "++X", "X++" -> ans++
            else -> ans--
        }
    }

    return ans
}