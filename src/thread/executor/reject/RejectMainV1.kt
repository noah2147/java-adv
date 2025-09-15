package thread.executor.reject

import thread.executor.RunnableTask
import util.MyLogger.Companion.log
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

fun main(){

    val es = ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, SynchronousQueue(), ThreadPoolExecutor.AbortPolicy())
    es.submit(RunnableTask("taskA"))
    try {
        es.submit(RunnableTask("taskB"))
    }catch (e: RejectedExecutionException){
        log("요청 초과")
        log(e)
    }
    es.close()
}