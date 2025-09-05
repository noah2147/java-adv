package thread.volatile1

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

fun main(){


    class MyTask: Runnable{

        @Volatile var flag = true
        @Volatile var count = 0
        override fun run() {

            while (flag){
                count++
                if(count % 100_000_000 == 0){
                    log("flag = $flag, count = $count in while{}")
                }
            }
            log("flag = $flag, count = $count 종료")
        }
    }

    val task = MyTask()
    val t = Thread(task, "work")
    t.start()
    sleep(1000)
    task.flag = false
    log("flag = ${task.flag} count = ${task.count} in main")
}