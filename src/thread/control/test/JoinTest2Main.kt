package thread.control.test

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

fun main() {

    val myTask = Runnable {
        (1..3).forEach {
            log(it)
            sleep(1000)
        }
    }

    val t1 = Thread(myTask)
    val t2 = Thread(myTask)
    val t3 = Thread(myTask)

    t1.start()
    t2.start()
    t3.start()

    t1.join()
    t2.join()
    t3.join()
    println("모든 스레드 실행 완료 ")
}