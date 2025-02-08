package leetcode

import java.util.*

fun main() {
//    val nc1 = NumberContainers()
//
//    println(nc1.find(10)) // There is no index that is filled with number 10. Therefore, we return -1.
//    println(nc1.change(2, 10)) // Your container at index 2 will be filled with number 10.
//    println(nc1.change(1, 10)) // Your container at index 1 will be filled with number 10.
//    println(nc1.change(3, 10)) // Your container at index 3 will be filled with number 10.
//    println(nc1.change(5, 10)) // Your container at index 5 will be filled with number 10.
//    println(nc1.find(10)) // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
//    println(nc1.change(1,20)) // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20.
//    println(nc1.find(10)) // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.

    val nc2 = NumberContainers()

    println(nc2.change(1, 10))
    println(nc2.find(10))
    println(nc2.change(1, 20))
    println(nc2.find(10))
    println(nc2.find(20))
    println(nc2.find(30))
}

class NumberContainers() {
    private val i = hashMapOf<Int, Int>()
    private val n = hashMapOf<Int, TreeSet<Int>>()

    fun change(index: Int, number: Int) {
        i[index]?.let { prev -> n[prev]?.remove(index) }
        i[index] = number
        n[number] = n.getOrDefault(number, TreeSet<Int>()).apply { add(index) }
    }

    fun find(number: Int): Int {
        val result = n[number]

        return if (result.isNullOrEmpty()) -1 else result.first()
    }
}

// https://leetcode.com/problems/design-a-number-container-system/description/