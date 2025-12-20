package leetcode.quest.stack

fun main() {
    val (n1, logs1) = 2 to listOf("0:start:0", "1:start:2", "1:end:5", "0:end:6")
    val (n2, logs2) = 1 to listOf("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7")
    val (n3, logs3) = 2 to listOf("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7")

    println(exclusiveTime(n1, logs1).joinToString())
    println(exclusiveTime(n2, logs2).joinToString())
    println(exclusiveTime(n3, logs3).joinToString())
}

private fun exclusiveTime(n: Int, logs: List<String>): IntArray {
    val ans = IntArray(n)
    val stack = mutableListOf<Int>()
    var prev = 0

    for (l in logs) {
        val split = l.split(":")
        val func = split[0].toInt()
        val state = split[1]
        val time = split[2].toInt()

        if (state == "start") {
            if (stack.isNotEmpty()) {
                ans[stack.last()] += time - prev
            }
            stack.add(func)
            prev = time
        } else {
            ans[stack.removeLast()] += time - prev + 1
            prev = time + 1
        }
    }

    return ans
}

// https://leetcode.com/problems/exclusive-time-of-functions/description/