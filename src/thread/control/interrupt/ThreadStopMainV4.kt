package thread.control.interrupt

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

fun main() {

    val myTask = Runnable {

        while (!Thread.interrupted()){
            log("작업중 ")
        }
        log("work 스레드 인터럽트 상태 2 = ${Thread.currentThread().isInterrupted}")
        try {
            log("자원 정리 시도")
            Thread.sleep(1000)
            log("자원 정리 완료")
        }catch (e : InterruptedException){
            log("자원 정리 실패 - 자원 정리 중 인터럽트 발생")
            log("work 스레드 인터럽트 상태 3 = ${Thread.currentThread().isInterrupted}")
        }finally {
            log("작업 종료")
        }
    }

    val thread = Thread(myTask, "work")
    thread.start()
    Thread.sleep(100)
    log("작업 중단 지시 thread.interrupt()")
    thread.interrupt()
    log("work 스레드 인터럽트 상태 1 = ${thread.isInterrupted}")
}