package string

private fun main() {
    val case1 = arrayOf("dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero")
    val case2 = arrayOf("a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo")

    println(reorderLogFiles(case1))
    println(reorderLogFiles(case2))
}

private fun reorderLogFiles(logs: Array<String>): List<String> {
    return logs.sortedWith(
        comparator = Comparator { o1, o2 ->
            val (o1Log, o2Log) = o1.substringAfter(" ") to o2.substringAfter(" ")

            if (o1Log.any { it.isLetter() } && o2Log.any { it.isDigit() }) return@Comparator -1
            if (o1Log.any { it.isDigit() } && o2Log.any { it.isLetter() }) return@Comparator 1
            if (o1Log.any { it.isDigit() } && o2Log.any { it.isDigit() }) return@Comparator 0
            if (o1Log == o2Log) return@Comparator compareValues(o1.substringBefore(" "), o2.substringBefore(" "))

            return@Comparator compareValues(o1Log, o2Log)
        }
    )
}

// https://leetcode.com/problems/reorder-data-in-log-files/