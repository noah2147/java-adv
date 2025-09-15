package thread.executor.future

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors

fun main() {

    class ExCallable(): Callable<Int> {
        override fun call(): Int? {
            log("Callable 실행 , 예외 발생")
            throw IllegalArgumentException("ex!")
        }
    }

    val es = Executors.newFixedThreadPool(1)
    log("작업 전달")
    val future = es.submit(ExCallable())
    sleep(1000)

    try {
        log("future.get() 호출 시도, future.state(): " + future.state())
        val result = future.get()
        log("result value = $result")
    }catch (e: InterruptedException) {
        throw RuntimeException(e)
    }catch (e: ExecutionException) {
        log("e = $e")
        val cause = e.cause
        log("cause = $cause")
    }

    es.close()
}