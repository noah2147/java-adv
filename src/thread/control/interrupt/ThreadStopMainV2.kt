package thread.control.interrupt

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

fun main() {

    val myTask = Runnable {
        try {
            while (true){
                log("작업중 ")
                Thread.sleep(3000)
            }
        }catch (e : InterruptedException){
            log("work 스레드 인터럽트 상태 2 = ${Thread.currentThread().isInterrupted}")
            log("interrupt messege = ${e.message}")
            log("state = ${Thread.currentThread().state}")
        }finally {
            log("자원 정리")
            log("작업 종료")
        }
    }

    val thread = Thread(myTask, "work")
    thread.start()
    sleep(4000)
    log("작업 중단 지시 thread.interrupt()")
    thread.interrupt()
    log("work 스레드 인터럽트 상태 1 = ${thread.isInterrupted}")
}