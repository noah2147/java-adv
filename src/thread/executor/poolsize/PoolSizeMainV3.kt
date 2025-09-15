package thread.executor.poolsize

import thread.executor.ExecutorUtils.Companion.printState
import thread.executor.RunnableTask
import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.Executors
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

fun main(){

//    val es = Executors.newCachedThreadPool()
    val es = ThreadPoolExecutor(0, Int.MAX_VALUE, 3, TimeUnit.SECONDS, SynchronousQueue())
    log("pool 생성 ")
    printState(es)

    (1..4).forEach {
        es.execute(RunnableTask("task$it"))
        printState(es, taskName = "task$it")
    }

    sleep(3000);
    log("== 작업 수행 완료 ==");
    printState(es);

    sleep(3000);
    log("== maximumPoolSize 대기 시간 초과 ==");
    printState(es);

    es.close();
    log("== shutdown 완료 ==");
    printState(es);
}