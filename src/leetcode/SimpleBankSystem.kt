package leetcode

fun main() {
    val bank = Bank(longArrayOf(10, 100, 20, 50, 30))
    val cmd = listOf("withdraw", "transfer", "deposit", "transfer", "withdraw")
    val values = listOf(
        longArrayOf(3, 10),
        longArrayOf(5, 1, 20),
        longArrayOf(5, 20),
        longArrayOf(3, 4, 15),
        longArrayOf(10, 50),
    )

    cmd.mapIndexed { i, v ->
        when (v) {
            "withdraw" -> bank.withdraw(values[i][0].toInt(), values[i][1])
            "transfer" -> bank.transfer(values[i][0].toInt(), values[i][1].toInt(), values[i][2])
            "deposit" -> bank.deposit(values[i][0].toInt(), values[i][1])
            else -> false
        }
    }.run(::println)
}

class Bank(balance: LongArray) {
    private val accounts = balance

    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        if (account1 > accounts.size || account2 > accounts.size) return false

        val from = account1 - 1
        val to = account2 - 1

        if(accounts[from] < money) return false

        accounts[to] += money
        accounts[from] -= money

        return true
    }

    fun deposit(account: Int, money: Long): Boolean {
        if (account > accounts.size) return false

        val uid = account - 1

        accounts[uid] += money

        return true
    }

    fun withdraw(account: Int, money: Long): Boolean {
        if (account > accounts.size) return false

        val uid = account - 1

        if(accounts[uid] < money) return false

        accounts[uid] -= money

        return true
    }
}

// https://leetcode.com/problems/simple-bank-system/description/