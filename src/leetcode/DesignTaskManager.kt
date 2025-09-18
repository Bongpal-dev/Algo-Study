package leetcode

import java.util.*

fun main() {
    val tm = TaskManager(
        listOf(listOf(1, 101, 10), listOf(2, 102, 20), listOf(3, 103, 15))
    )
    val cmd = listOf("add", "edit", "execTop", "rmv", "add", "execTop")
    val data = listOf(listOf(4, 104, 5), listOf(102, 8), listOf(), listOf(101), listOf(5, 105, 15), listOf())

    cmd.mapIndexed { i, c ->
        when (c) {
            "add" -> {
                val (uid, tid, p) = data[i]

                tm.add(uid, tid, p)
                null
            }

            "edit" -> {
                val (tid, np) = data[i]

                tm.edit(tid, np)
                null
            }

            "rmv" -> {
                tm.rmv(data[i][0])
                null
            }

            "execTop" -> {
                return@mapIndexed tm.execTop()
            }

            else -> {}
        }
    }.run(::println)
}

private class TaskManager(tasks: List<List<Int>>) {
    private val map = mutableMapOf<Int, User>()
    private val pq = PriorityQueue(compareByDescending<Task> { it.priority }.thenByDescending { it.id })

    init {
        tasks.forEach { (uid, tid, p) ->
            map[tid] = User(uid, p)
            pq.add(Task(tid, p))
        }
    }

    fun add(userId: Int, taskId: Int, priority: Int) {
        map[taskId] = User(userId, priority)
        pq.add(Task(taskId, priority))
    }

    fun edit(taskId: Int, newPriority: Int) {
        map[taskId]?.let {
            map[taskId] = User(it.id, newPriority)
        }
        pq.add(Task(taskId, newPriority))
    }

    fun rmv(taskId: Int) {
        map.remove(taskId)
    }

    fun execTop(): Int {
        while (pq.isNotEmpty()) {
            val top = pq.peek()
            val cur = map[top.id]

            if (cur == null || cur.priority != top.priority) {
                pq.poll()
                continue
            }
            pq.poll()
            map.remove(top.id)

            return cur.id
        }

        return -1
    }
}

private data class Task(
    val id: Int,
    val priority: Int,
)

private data class User(
    val id: Int,
    val priority: Int,
)

// https://leetcode.com/problems/design-task-manager/description