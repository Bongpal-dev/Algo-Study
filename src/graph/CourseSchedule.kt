package graph

fun main() {
    val (numCourses1, prerequisites1) = 2 to arrayOf(intArrayOf(1, 0))
    val (numCourses2, prerequisites2) = 2 to arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
    val (numCourses3, prerequisites3) = 20 to arrayOf(
        intArrayOf(0, 10),
        intArrayOf(3, 18),
        intArrayOf(5, 5),
        intArrayOf(6, 11),
        intArrayOf(11, 14),
        intArrayOf(13, 1),
        intArrayOf(15, 1),
        intArrayOf(17, 4),
    )
    val (numCourses4, prerequisites4) = 5 to arrayOf(
        intArrayOf(1, 4),
        intArrayOf(2, 4),
        intArrayOf(3, 1),
        intArrayOf(3, 2),
    )
    val (numCourses5, prerequisites5) = 4 to arrayOf(
        intArrayOf(2, 0),
        intArrayOf(1, 0),
        intArrayOf(3, 1),
        intArrayOf(3, 2),
        intArrayOf(1, 3),
    )

    println(canFinish(numCourses1, prerequisites1))
    println(canFinish(numCourses2, prerequisites2))
    println(canFinish(numCourses3, prerequisites3))
    println(canFinish(numCourses4, prerequisites4))
    println(canFinish(numCourses5, prerequisites5))
}

private fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    if (prerequisites.isEmpty()) return true

    val inDegree = IntArray(numCourses) { 0 }
    val graph = hashMapOf<Int, MutableList<Int>>()
    val queue = mutableListOf<Int>()
    var count = 0

    for ((c,p) in prerequisites) {
        graph.getOrPut(p) { mutableListOf() }.add(c)
        inDegree[c]++
    }

    for (i in inDegree.indices) {
        if (inDegree[i] == 0) queue.add(i)
    }

    while (queue.isNotEmpty()) {
        val course = queue.removeFirst()

        count++

        for (n in graph[course] ?: emptyList()) {
            inDegree[n]--

            if (inDegree[n] == 0)queue.add(n)
        }
    }

    return count == numCourses
}

// https://leetcode.com/problems/course-schedule/description/