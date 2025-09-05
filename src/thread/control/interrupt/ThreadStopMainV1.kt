package thread.control.interrupt

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

fun main() {

    val myTask = object : Runnable {

        @Volatile
        var runFlag = true

        override fun run() {
            while (runFlag){
                log("작업중 ")
                sleep(3000)
            }
            log("자원 정리")
            log("작업 종료")
        }
    }

    val thread = Thread(myTask, "work")
    thread.start()
    sleep(4000)
    log("작업 중단 지시 runFlag = false")
    myTask.runFlag = false
}