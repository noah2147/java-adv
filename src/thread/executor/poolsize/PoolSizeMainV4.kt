package thread.executor.poolsize

import thread.executor.ExecutorUtils.Companion.printState
import thread.executor.RunnableTask
import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

fun main(){

//    val taskSize = 1100
//    val taskSize = 1200
    val taskSize = 1201

    val es = ThreadPoolExecutor(100, 200, 60, TimeUnit.SECONDS, ArrayBlockingQueue(1000))
    log("pool 생성 ")
    printState(es)

    val startMs = System.currentTimeMillis()

    repeat(taskSize){
        val taskName = "task$it"
        try {
            es.execute(RunnableTask(taskName))
            printState(es, taskName)
        }catch (e: RejectedExecutionException){
            log("$taskName -> $e")
        }
    }

    es.close();
    val endMs = System.currentTimeMillis()
    log("time: ${endMs - startMs}");
}