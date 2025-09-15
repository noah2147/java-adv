package thread.executor

import thread.executor.ExecutorUtils.Companion.printState
import util.MyLogger.Companion.log
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main(){

    val es = Executors.newFixedThreadPool(2)
    es.execute(RunnableTask("taskA"))
    es.execute(RunnableTask("taskB"))
    es.execute(RunnableTask("taskC"))
    es.execute(RunnableTask("task-Long", 100_000))
    printState(es)

    log("== shutdown start ==")
    shutdownAndAwaitTermination(es)
    log("== shutdown end ==")
    printState(es)

}

fun shutdownAndAwaitTermination(es: ExecutorService){
    es.shutdown()
    try {
        log("서비스 정상 종료 시도")
        if(!es.awaitTermination(10, TimeUnit.SECONDS)){
            log("서비스 정상 종료 실패 -> 강종 시도")
            es.shutdownNow()

            if(!es.awaitTermination(10, TimeUnit.SECONDS)){
                log("서비스가 종료되지 않았습니다")
            }
        }
    }catch (e : InterruptedException){
        es.shutdownNow()
    }
}