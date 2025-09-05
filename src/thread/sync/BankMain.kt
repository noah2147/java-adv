package thread.sync

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

fun main() {

    val account = BankAccountV6(1000)

    val t1 = Thread(WithdrawTask(account, 800), "t1")
    val t2 = Thread(WithdrawTask(account, 800), "t2")

    t1.start()
    t2.start()

    sleep(500)

    log("t1 state: ${t1.state}")
    log("t2 state: ${t2.state}")

    t1.join()
    t2.join()

    log("최종 잔액: ${account.getBalance()}")
}