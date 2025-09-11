package thread.cas.spinlock

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.atomic.AtomicBoolean

class SpinLock(
    var lock: AtomicBoolean = AtomicBoolean(false)
) {
    fun lock() {
        log("락 획득 시도")
        while (!lock.compareAndSet(false, true)) {
            log("락 획득 실패 - 스핀 대기")
        }
        log("락 획득 완료")
    }

    fun unLock() {
        lock.set(false)
        log("락 반납 완료")
    }
}