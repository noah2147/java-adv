package thread.executor.poolsize

import thread.executor.ExecutorUtils.Companion.printState
import thread.executor.RunnableTask
import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

fun main(){

    val es = Executors.newFixedThreadPool(2)
    log("pool 생성")
    printState(es)

    (1..6).forEach { it ->
        es.execute(RunnableTask("task$it"))
        printState(es, taskName = "task$it")
    }

    es.close()
    log("shutdown 완료")
}