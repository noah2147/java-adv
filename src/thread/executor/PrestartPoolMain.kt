package thread.executor

import thread.executor.ExecutorUtils.Companion.printState
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

fun main(){

    val es = Executors.newFixedThreadPool(1000)
    printState(es)

    val poolExecutor =  es as ThreadPoolExecutor
    poolExecutor.prestartAllCoreThreads()
    printState(es)
}