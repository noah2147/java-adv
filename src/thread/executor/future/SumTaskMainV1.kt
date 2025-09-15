package thread.executor.future

import util.MyLogger.Companion.log

@Throws(InterruptedException::class)
fun main(){

    class SumTask(
        val start: Int,
        val end: Int,
        var result: Int = 0,
    ): Runnable{
        override fun run() {
            log("작업 시작")

            try {
                Thread.sleep(2000)
            }catch (e : InterruptedException){
                throw RuntimeException(e)
            }

            var sum = 0
            (start..end).forEach { sum += it }
            result = sum
            log("작업 완료 result = $result")
        }
    }

    val task1 = SumTask(1, 50)
    val task2 = SumTask(51, 100)

    val th1 = Thread(task1, "th-1")
    val th2 = Thread(task2, "th-2")

    th1.start()
    th2.start()

    log("join() - main th 가 th1, th2 종료 까지 대기")
    th1.join()
    th2.join()
    log("main 스레드 대기 완료 ")

    log("task1.result = ${task1.result}")
    log("task2.result = ${task2.result}")

    val sumAll = task1.result + task2.result
    log("task1 + task2 = $sumAll")
    log("end")
}

