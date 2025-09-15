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
    val future = es.submit<Int> {
        log("Callable start")
        sleep(2000)
        val value = Random.nextInt(10)
        log("create value = $value")
        log("Callable end")
        value
    }
    val result = future.get()
    log("result value = $result")
    es.close()
}