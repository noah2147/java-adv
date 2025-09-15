package thread.executor.poolsize

import thread.executor.ExecutorUtils.Companion.printState
import thread.executor.RunnableTask
import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

fun main(){

    val workQueue = ArrayBlockingQueue<Runnable>(2)
    val es = ThreadPoolExecutor(2, 4, 3000, TimeUnit.MILLISECONDS, workQueue)
    printState(es)

    es.execute(RunnableTask("taskA"))
    printState(es)

    es.execute(RunnableTask("taskB"))
    printState(es)

    es.execute(RunnableTask("taskC"))
    printState(es)

    es.execute(RunnableTask("taskD"))
    printState(es)

    es.execute(RunnableTask("taskE"))
    printState(es)

    es.execute(RunnableTask("taskF"))
    printState(es)

    try {
        es.execute(RunnableTask("task7"))
    }catch (e: RejectedExecutionException){
        log("task7 실행 거절 예외 발생 $e")
    }

    sleep(3000)
    log("작업 수행 완료")
    printState(es)

    sleep(3000)
    log("maximum pool size 대기 시간 초과")
    printState(es)

    es.close()
    log("shutdown 완료")
    printState(es)
}