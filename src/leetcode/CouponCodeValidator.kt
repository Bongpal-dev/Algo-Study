package leetcode

fun main() {
    val (code1, businessLine1) = arrayOf("SAVE20", "", "PHARMA5", "SAVE@20") to arrayOf(
        "restaurant",
        "grocery",
        "pharmacy",
        "restaurant"
    )
    val isActive1 = booleanArrayOf(true, true, true, true)
    val (code2, businessLine2) = arrayOf("GROCERY15", "ELECTRONICS_50", "DISCOUNT10") to arrayOf(
        "grocery",
        "electronics",
        "invalid"
    )
    val isActive2 = booleanArrayOf(false, true, true)

    println(validateCoupons(code1, businessLine1, isActive1))
    println(validateCoupons(code2, businessLine2, isActive2))
}

private fun validateCoupons(code: Array<String>, businessLine: Array<String>, isActive: BooleanArray): List<String> {
    val line = hashSetOf("electronics", "grocery", "pharmacy", "restaurant")
    val r = "[a-zA-Z0-9_]*".toRegex()
    val coupons = code.mapIndexed { i, c ->
        Coupon(
            code = c,
            businessLine = businessLine[i],
            isActive = isActive[i],
        )
    }

    return coupons
        .sortedWith(compareBy({ it.businessLine }, { it.code }))
        .filterNot { it.code.isEmpty() || r.matches(it.code).not() || it.businessLine !in line || it.isActive.not() }
        .map { it.code }
}

private data class Coupon(
    val code: String,
    val businessLine: String,
    val isActive: Boolean
)

// https://leetcode.com/problems/coupon-code-validator/description/