package thread.executor.future

import thread.executor.CallableTask
import util.MyLogger.Companion.log
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import kotlin.jvm.Throws

@Throws(InterruptedException::class, ExecutionException::class)
fun main() {

    val es = Executors.newFixedThreadPool(10)

    val tasks = (1..3).map {
        val callableTask = CallableTask("task$it", it * 1000)
        callableTask
    }.toList()

    val futures = es.invokeAll(tasks)
    futures.forEach { it ->
        val value = it.get()
        log("value = $value")
    }

    es.close()
}