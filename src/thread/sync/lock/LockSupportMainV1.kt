package thread.sync.lock

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.locks.LockSupport

fun main(){

    val task = Runnable{
        log("park 시작")
        LockSupport.park()
        log("park 종료, state = ${Thread.currentThread().state}")
        log("인터럽트 상태 : ${Thread.currentThread().isInterrupted}")
    }

    val thread = Thread(task, "t1")
    thread.start()

    sleep(100)
    log("Thread -1 state : ${thread.state}")

    log("main -> unpark(Thread-1)")
//    LockSupport.unpark(thread)
    thread.interrupt()
}