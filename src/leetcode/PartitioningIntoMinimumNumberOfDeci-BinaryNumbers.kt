package leetcode

 fun main() {
     val n1 = "32"
     val n2 = "82734"
     val n3 = "27346209830709182346"

     println(minPartitions(n1))
     println(minPartitions(n2))
     println(minPartitions(n3))
 }

private fun minPartitions(n: String): Int {
    var ans = 0

    for(e in n) {
        val num = e.digitToInt()

        ans = maxOf(ans, num)

        if(ans == 9) break
    }

    return ans
}

// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/