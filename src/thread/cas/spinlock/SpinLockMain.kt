package thread.cas.spinlock

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

fun main(){

//    val spinLock = SpinLockBad()
    val spinLock = SpinLock()

    val task = Runnable {
        spinLock.lock()
        try { // 임계 영역
            log("비즈니스 로직 실행")
            sleep(1)
        } finally {
            spinLock.unLock()
        }
    }

    Thread(task, "thread-1").start()
    Thread(task, "thread-2").start()
}