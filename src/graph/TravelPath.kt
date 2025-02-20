package graph

import java.util.PriorityQueue

fun main() {
    val case1 = arrayOf(
        arrayOf("ICN", "JFK"),
        arrayOf("HND", "IAD"),
        arrayOf("JFK", "HND"),
    )
    val case2 = arrayOf(
        arrayOf("ICN", "SFO"),
        arrayOf("ICN", "ATL"),
        arrayOf("SFO", "ATL"),
        arrayOf("ATL", "ICN"),
        arrayOf("ATL", "SFO"),
    )

    println(solution(case1).joinToString())
    println(solution(case2).joinToString())
}

private fun solution(tickets: Array<Array<String>>): Array<String> {
    val graph = hashMapOf<String, PriorityQueue<String>>()
    val answer = mutableListOf<String>()

    tickets.forEach { (f, t) ->
        graph.getOrPut(f) { PriorityQueue() }.add(t)
    }
    find("ICN", graph, answer)
    answer.reverse()

    return answer.toTypedArray()
}

private fun find(s: String, graph: HashMap<String, PriorityQueue<String>>, answer: MutableList<String>) {
    while (graph[s].isNullOrEmpty().not()) {
        find(graph[s]!!.poll(), graph, answer)
    }
    answer.add(s)
}

// https://school.programmers.co.kr/learn/courses/30/lessons/43164?language=kotlin