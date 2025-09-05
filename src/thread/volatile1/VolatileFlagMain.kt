package thread.volatile1

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

fun main(){


    class MyTask: Runnable{

        @Volatile
        var runFlag = true

        override fun run() {
            log("task 시작 ")
            while (runFlag){ }
            log("task 종료")
        }
    }

    val myTask = MyTask()
    val thread = Thread(myTask, "work")
    log("runFlag = ${myTask.runFlag}")
    thread.start()

    sleep(1000)
    log("runFlag false 변경 시도= ${myTask.runFlag}")
    myTask.runFlag =false
    log("runFlag = ${myTask.runFlag}")
    log("main 종료")
}