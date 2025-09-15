package thread.executor.reject

import thread.executor.RunnableTask
import util.MyLogger.Companion.log
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.RejectedExecutionHandler
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

fun main(){

    class CustomRejectHandler(
        val count: AtomicInteger = AtomicInteger(0)
    ): RejectedExecutionHandler{
        override fun rejectedExecution(r: Runnable?, executor: ThreadPoolExecutor?) {
            val i = this.count.incrementAndGet()
            log("[경고] 거절된 누적 작업 수 $i")
        }
    }

    val es = ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
        SynchronousQueue(),
        CustomRejectHandler()
    )
    es.submit(RunnableTask("taskA"))
    es.submit(RunnableTask("taskB"))
    es.submit(RunnableTask("taskC"))
    es.close()
}