package thread.executor.future

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import kotlin.random.Random


@Throws(ExecutionException::class, InterruptedException::class)
fun main() {

    val es = Executors.newFixedThreadPool(1)
    log("submit() 호출 ")
    val future = es.submit<Int> {
        log("Callable start")
        sleep(2000)
        val value = Random.nextInt(10)
        log("create value = $value")
        log("Callable end")
        value
    }
    log("future 즉시 반환, future = $future")

    log("future.get() [blocking] 메서드 호출 시작 -> main 스레드 waiting")
    val result = future.get()
    log("future.get() [blocking] 메서드 호출 완료 -> main 스레드 runnable")

    log("result value = $result")
    log("future 완료 , future = ${future}")
    es.close()
}