package thread.executor

import thread.executor.ExecutorUtils.Companion.printState
import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

fun main() {

    val es = ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, LinkedBlockingQueue<Runnable>())
    log("== 초기 상태 ==")
    printState(es)
    es.execute(RunnableTask("taskA"))
    es.execute(RunnableTask("taskB"))
    es.execute(RunnableTask("taskC"))
    es.execute(RunnableTask("taskD"))
    log("== 작업 수행 중 ==")
    printState(es)

    sleep(3000)
    log("== 작업 수행 완료 ==")
    printState(es)

    es.close()
    log("== shutdown 완료 ==")
    printState(es)
}
