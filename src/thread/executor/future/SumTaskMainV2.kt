package thread.executor.future

import util.MyLogger.Companion.log
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors

@Throws(InterruptedException::class, ExecutionException::class)
fun main(){

    class SumTask(
        val start: Int,
        val end: Int,
    ): Callable<Int>{
        @Throws(InterruptedException::class)
        override fun call(): Int? {
            log("작업 시작 ")
            Thread.sleep(2000)
            var sum = 0
            (start..end).forEach { sum+= it }
            log("작업 완료")
            return sum
        }
    }

    val task1 = SumTask(1, 50)
    val task2 = SumTask(51, 100)

    val es = Executors.newFixedThreadPool(2)
    val future1 = es.submit(task1)
    val future2 = es.submit(task2)

    val sum1 = future1.get()
    val sum2 = future2.get()

    log("task1.result = ${sum1}")
    log("task2.result = ${sum2}")

    val sumAll = sum1 + sum2
    log("task1 + task2 = $sumAll")
    log("end")
}

