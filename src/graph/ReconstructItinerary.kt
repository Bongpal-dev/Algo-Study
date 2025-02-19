package graph

import java.util.PriorityQueue

fun main() {
    val case1 = listOf(
        listOf("MUC", "LHR"),
        listOf("JFK", "MUC"),
        listOf("SFO", "SJC"),
        listOf("LHR", "SFO"),
    )
    val case2 = listOf(
        listOf("JFK", "SFO"),
        listOf("JFK", "ATL"),
        listOf("SFO", "ATL"),
        listOf("ATL", "JFK"),
        listOf("ATL", "SFO"),
    )
    val case3 = listOf(
        listOf("JFK", "KUL"),
        listOf("JFK", "NRT"),
        listOf("NRT", "JFK"),
    )

    println(findItinerary(case1))
    println(findItinerary(case2))
    println(findItinerary(case3))
}

private fun findItinerary(tickets: List<List<String>>): List<String> {
    val graph = hashMapOf<String, PriorityQueue<String>>()
    val answer = mutableListOf<String>()

    tickets.forEach { (f, t) ->
        graph.getOrPut(f) { PriorityQueue<String>() }.add(t)
    }
    find("JFK", graph, answer)
    answer.reverse()

    return answer
}

private fun find(p: String, graph: HashMap<String, PriorityQueue<String>>, answer: MutableList<String>) {
    val destinations = graph[p]

    while (!destinations.isNullOrEmpty()) {
        find(destinations.poll(), graph, answer)
    }
    answer.add(p)
}

// https://leetcode.com/problems/reconstruct-itinerary/description/