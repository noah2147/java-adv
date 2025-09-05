package thread.control

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

fun main() {

    class SumTask(
        private val startValue: Int,
        private val endValue: Int,
        var result: Int = 0,
    ): Runnable {
        override fun run() {
            log("작업 시작")
            sleep(2000)
            var sum = 0
            (startValue..endValue).forEach { sum+=it }
            this.result = sum
            log("작업 완료 = ${this.result}")
        }
    }

    log("start")
    val sumTask1 = SumTask(1, 50)
    val sumTask2 = SumTask(51, 100)

    val thread1 = Thread(sumTask1, "thread-1")
    val thread2 = Thread(sumTask2, "thread-2")

    thread1.start()
    thread2.start()

    log("join() - main 스레드가 th1 th2 종료할떄 까지 대기")
    thread1.join()
    thread2.join()

    log("main 스레드 대기 완료 ")
    log("thread1.result = ${sumTask1.result}")
    log("thread2.result = ${sumTask2.result}")

    val sumAll = sumTask1.result + sumTask2.result
    log("sumAll = $sumAll")
    log("end")
}
