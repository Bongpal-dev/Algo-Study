package string

private fun main() {
    val case1 = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val case2 = arrayOf("")
    val case3 = arrayOf("a")

    println(groupAnagrams(case1))
    println(groupAnagrams(case2))
    println(groupAnagrams(case3))
}

private fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val r = hashMapOf<String, List<String>>()

    strs.forEach { v ->
        val key = v.toCharArray().apply { sort() }.joinToString("")

        r[key] = r.getOrDefault(key, emptyList()) + listOf(v)
    }
    return r.values.toList()
}

// https://leetcode.com/problems/group-anagrams/description/