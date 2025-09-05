package thread.control

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

fun main() {

    class Job: Runnable {
        override fun run() {
            log("작업 시작")
            sleep(2000)
            log("작업 완료")
        }
    }

    log("start")
    val thread1 = Thread(Job(), "thread-1")
    val thread2 = Thread(Job(), "thread-2")

    thread1.start()
    thread2.start()
    log("end")
}
