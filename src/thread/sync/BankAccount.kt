package thread.sync

interface BankAccount {
    fun withdraw(amount: Int): Boolean
    fun getBalance(): Int
}