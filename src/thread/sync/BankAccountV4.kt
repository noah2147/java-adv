package thread.sync

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class BankAccountV4(
    private var balance: Int = 0,
    private val lock: Lock = ReentrantLock(),
) : BankAccount {

    override fun withdraw(amount: Int): Boolean {
        log("거래 시작 : ${this.javaClass.simpleName}")

        this.lock.lock()
        try {
            log("[검증 시작] 출금액: $amount 잔액: $balance")
            if (amount > balance) {
                log("[검증 실패] 출금액: $amount 잔액: $balance")
                return false
            }
            log("[검증 완료] 출금액: $amount 잔액: $balance")
            sleep(1000)
            balance -= amount
            log("[출금 완료] 출금액: $amount 변경 잔액: $balance")
        }finally {
            lock.unlock()
        }
        log("거래 종료")
        return true
    }

    override fun getBalance(): Int {
        lock.lock()
        try {
            return this.balance
        }finally {
            lock.unlock()
        }
    }
}