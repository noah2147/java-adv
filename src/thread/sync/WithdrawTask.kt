package thread.sync

class WithdrawTask(
    private val bankAccount: BankAccount,
    private var amount: Int
) : Runnable {

    override fun run() {
        this.bankAccount.withdraw(amount)
    }
}
