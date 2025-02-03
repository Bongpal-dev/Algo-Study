package hashtable

fun main() {
    val myHashMap = MyHashMap()
    println(myHashMap.put(1, 1)) // The map is now [[1,1]]
    println(myHashMap.put(2, 2)) // The map is now [[1,1], [2,2]]
    println(myHashMap.get(1)) // return 1, The map is now [[1,1], [2,2]]
    println(myHashMap.get(3)) // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    println(myHashMap.put(2, 1)) // The map is now [[1,1], [2,1]] (i.e., update the existing value)
    println(myHashMap.get(2)) // return 1, The map is now [[1,1], [2,1]]
    println(myHashMap.remove(2)) // remove the mapping for 2, The map is now [[1,1]]
    println(myHashMap.get(2)) // return -1 (i.e., not found), The map is now [[1,1]]
}

private class MyHashMap() {
    private val mArray = IntArray(1000001) { -1 }

    fun put(key: Int, value: Int) {
        mArray[key] = value
    }

    fun get(key: Int): Int {
        return mArray[key]
    }

    fun remove(key: Int) {
        mArray[key] = -1
    }
}

// https://leetcode.com/problems/design-hashmap/description/